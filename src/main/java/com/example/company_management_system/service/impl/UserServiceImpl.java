package com.example.company_management_system.service.impl;

import com.example.company_management_system.model.dto.UserDto;
import com.example.company_management_system.model.entity.User;
import com.example.company_management_system.exception.NotFoundException;
import com.example.company_management_system.model.mapper.UserMapper;
import com.example.company_management_system.repository.UserRepository;
import com.example.company_management_system.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void creatUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        try {
            userRepository.save(user);

        } catch (Exception ex) {
            throw new RuntimeException("Save zamani xeta bas verdi", ex);
        }

    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

    }

    @Transactional(rollbackOn = {SQLException.class, RuntimeException.class})
    @Override
    public UserDto UserGetById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bele id-li user tapilmadi: " + id));
        return userMapper.toDto(user);

    }

    @Transactional(rollbackOn = {SQLException.class, RuntimeException.class})
    @Override
    public void updateUserById(UserDto userDto, long id) {


        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bele id-li user tapilmadi: " + id));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
//        user.setBirthDate(userDto.getBirthDate());
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            throw new RuntimeException("Update zamani xeta bas verdi: " + id, ex);
        }


    }

    @Transactional(rollbackOn = {SQLException.class, RuntimeException.class})
    @Override
    public void deleteById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        try {
            userRepository.delete(user);
        } catch (Exception ex) {
            throw new RuntimeException("Delete zamani xeta bas verdi", ex);
        }

    }

}

