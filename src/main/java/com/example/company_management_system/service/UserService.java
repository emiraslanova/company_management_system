package com.example.company_management_system.service;

import com.example.company_management_system.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {


    void creatUser(UserDto userDto);

   List<UserDto> findAll();

    UserDto UserGetById(long id);

    void updateUserById(UserDto userDto, long id);

    void deleteById(long id);
}
