package com.example.demo.service;

import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.RoleDto;
import com.example.demo.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.enums.TokenType;
import com.example.demo.enums.UserRole;
import com.example.demo.exception.EmailExistException;
import com.example.demo.exception.PhoneNumberExistException;
import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.request.*;
import com.example.demo.utils.OtpGenerate;
import com.example.demo.config.JwtUtility;
import com.example.demo.model.response.ResponseApi;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final JwtUtility jwtUtility;

    private final PasswordEncoder passwordEncoder;

    private final Jedis jedis;

    private final MailService mailService;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtility jwtUtility,
                           PasswordEncoder passwordEncoder,
                           Jedis jedis, MailService mailService, UserMapper userMapper,
                           RoleMapper roleMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtUtility = jwtUtility;
        this.passwordEncoder = passwordEncoder;
        this.jedis = jedis;
        this.mailService = mailService;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> register(RegisterRequest registerRequest) {
        log.info("Start API: register with parameters: ({})", registerRequest);
        try {
            if (userMapper.existsByEmail(registerRequest.getEmail()))
                throw new EmailExistException(String.format("Email %s is already exist", registerRequest.getEmail()));

            if (userMapper.existsByPhoneNumber(registerRequest.getPhoneNumber()))
                throw new PhoneNumberExistException(String.format("Phone number %s is already exist", registerRequest.getPhoneNumber()));

            String otp = OtpGenerate.generateNumberOtp(6);
            MailRequest mailRequest = new MailRequest(registerRequest.getEmail(), "OTP for verification", otp);
            jedis.set(String.format("OTP:%s", registerRequest.getEmail()), otp);
            jedis.expire(registerRequest.getEmail(), 1200);
            mailService.sendTextMessage(mailRequest);
            log.info("End API: register");
            return new ResponseEntity<>(new ResponseApi<>("Register success"), HttpStatus.OK);
        } catch (EmailExistException | PhoneNumberExistException e) {
            log.error("Error API: register with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: register with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<ResponseApi<LoginDto>> login(LoginRequest loginRequest) {
        log.info("Start API: login with parameters: ({})", loginRequest);
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            List<UserRole> userRoleList = authentication.getAuthorities().stream()
                    .map(authority -> UserRole.valueOf(authority.getAuthority()))
                    .collect(Collectors.toList());
            String accessToken = jwtUtility.generateToken(loginRequest.getEmail(), TokenType.ACCESS_TOKEN, userRoleList);
            String refreshToken = jwtUtility.generateToken(loginRequest.getEmail(), TokenType.REFRESH_TOKEN, userRoleList);
            LoginDto loginDto = LoginDto.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();
            log.info("End API: login");
            return new ResponseEntity<>(new ResponseApi<>("Login success", loginDto), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            log.error("Error API: login with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>("Wrong email or password"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error API: login with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseApi<?>> verifyUserAccount(RegisterRequest registerRequest) {
        log.info("Start API: verifyUserAccount with parameters: ({})", registerRequest);
        String userOTP = jedis.get(String.format("OTP:%s", registerRequest.getEmail()));
        if (!registerRequest.getOTP().equals(userOTP)) {
            return new ResponseEntity<>(new ResponseApi<>("OTP is incorrect, try again"), HttpStatus.BAD_REQUEST);
        }
        UserDto user = UserDto.builder()
                .dob(registerRequest.getDob())
                .email(registerRequest.getEmail())
                .address(registerRequest.getAddress())
                .name(registerRequest.getName())
                .gender(registerRequest.getGender())
                .phoneNumber(registerRequest.getPhoneNumber())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userMapper.register(user);
        RoleDto roleDto = roleMapper.getByName(UserRole.CUSTOMER);
        roleMapper.setRole(user.getId(), roleDto.getId());
        jedis.del(String.format("OTP:%s", registerRequest.getEmail()));
        log.info("End API: verifyUserAccount");
        return new ResponseEntity<>(new ResponseApi<>("Verify success"), HttpStatus.CREATED);
    }
}
