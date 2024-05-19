//package com.example.demo.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import com.example.demo.entity.Role;
//import com.example.demo.entity.User;
//import com.example.demo.enums.UserRole;
//import com.example.demo.exception.EmailExistException;
//import com.example.demo.exception.PhoneNumberExistException;
//import com.example.demo.model.dto.EmployeeDto;
//import com.example.demo.model.request.CreateEmployeeRequest;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.RoleRepository;
//import com.example.demo.repository.UserRepository;
//
//@Service
//@Slf4j
//public class ManageEmployeeServiceImpl implements ManageEmployeeService {
//    private final UserRepository userRepository;
//
//    private final ModelMapper modelMapper;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final RoleRepository roleRepository;
//
//    public ManageEmployeeServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<Page<EmployeeDto>>> getListEmployee(String name, int page, int limit) {
//        log.info("Start API: getListEmployee with parameters: (name: {}, page: {}, limit: {})", name, page, limit);
//        Pageable pageable = PageRequest.of(page, limit);
//        Page<User> employeeInPage = name != null
//                ? userRepository.findByRoleAndName(UserRole.EMPLOYEE.name(), name, pageable)
//                : userRepository.findByRole(UserRole.EMPLOYEE.name(), pageable);
//        Page<EmployeeDto> employeeDto = employeeInPage.map(employee -> modelMapper.map(employee, EmployeeDto.class));
//        log.info("End API: getListEmployee");
//        return new ResponseEntity<>(new ResponseApi<>("Get list employee success", 200, employeeDto), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> createEmployee(CreateEmployeeRequest createEmployeeRequest) {
//        log.info("Start API: createEmployee with parameters: ({})", createEmployeeRequest);
//        try {
//            if (userRepository.findByEmail(createEmployeeRequest.getEmail()) != null)
//                throw new EmailExistException(String.format("Email %s is already exist", createEmployeeRequest.getEmail()));
//
//            if (userRepository.findByPhoneNumber(createEmployeeRequest.getPhoneNumber()) != null)
//                throw new PhoneNumberExistException(String.format("Phone number %s is already exist", createEmployeeRequest.getPhoneNumber()));
//            createEmployeeRequest.setPassword(passwordEncoder.encode(createEmployeeRequest.getPassword()));
//            User user = modelMapper.map(createEmployeeRequest, User.class);
//            Set<Role> role = new HashSet<>();
//            role.add(roleRepository.findByRole(createEmployeeRequest.getRole()));
//            user.setRole(role);
//            userRepository.save(user);
//            log.info("End API: createEmployee");
//            return new ResponseEntity<>(new ResponseApi<>("Create employee success", 201), HttpStatus.CREATED);
//        } catch (EmailExistException | PhoneNumberExistException e) {
//            log.error("Error API: createEmployee with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            log.error("Error API: createEmployee with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public ResponseEntity<ResponseApi<?>> deleteEmployee(Long id) {
//        log.info("Start API: deleteEmployee with parameters: (id: {})", id);
//        try {
//            User user = userRepository.findById(id).get();
//            Role role = roleRepository.findByRole(UserRole.EMPLOYEE);
//            user.getRole().remove(role);
//            userRepository.deleteById(id);
//            log.info("End API: deleteEmployee");
//            return new ResponseEntity<>(new ResponseApi<>("Delete employee success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: deleteEmployee with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
