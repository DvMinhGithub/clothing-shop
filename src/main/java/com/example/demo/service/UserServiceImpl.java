//package com.example.demo.service;
//
//import com.example.demo.mapper.UserMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//import com.example.demo.model.request.UserRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.model.dto.UserDto;
//
//@Service
//@Slf4j
//public class UserServiceImpl implements UserService {
//    private final ModelMapper modelMapper;
//
//    private final UserMapper userMapper;
//
//    public UserServiceImpl(UserMapper userMapper, ModelMapper modelMapper) {
//        this.userMapper = userMapper;
//        this.modelMapper = modelMapper;
//    }
//
//    public ResponseEntity<ResponseApi<?>> updateProfile(Principal principal, UserRequest userRequest) {
//        log.info("Start API: updateProfile with parameters: ({})", userRequest);
//        try {
//            User user = userRepository.findByEmail(principal.getName());
//            modelMapper.map(userRequest, user);
//            userRepository.save(user);
//            log.info("End API: updateProfile");
//            return new ResponseEntity<>(new ResponseApi<>("Update profile success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: updateProfile with message {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 200), HttpStatus.OK);
//        }
//    }
//
//    public ResponseEntity<ResponseApi<UserDto>> getProfile(Principal principal) {
//        log.info("Start API: getProfile");
//        User user = userRepository.findByEmail(principal.getName());
//        UserDto userDto = modelMapper.map(user, UserDto.class);
//        log.info("End API: getProfile");
//        return new ResponseEntity<>(new ResponseApi<>("Get profile success", 200, userDto), HttpStatus.OK);
//    }
//}
