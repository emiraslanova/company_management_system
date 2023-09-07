package com.example.company_management_system.model.mapper;

import com.example.company_management_system.model.dto.UserDto;
import com.example.company_management_system.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
