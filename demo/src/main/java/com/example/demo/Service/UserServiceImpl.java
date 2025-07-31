package com.example.demo.Service;

import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Convert Entity to DTO
    private UserDto convertToDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setStatus(user.getStatus());
        dto.setRoles(user.getRoles());
        return dto;
    }

    // Convert DTO to Entity
    private UserEntity convertToEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setCreatedDate(dto.getCreatedDate());
        user.setStatus(dto.getStatus());
        user.setRoles(dto.getRoles());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        return user;
    }


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user = convertToEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return convertToDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return convertToDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setStatus(userDto.getStatus());
        existingUser.setRoles(userDto.getRoles());
        existingUser.setCreatedDate(userDto.getCreatedDate());

        return convertToDto(userRepository.save(existingUser));
    }

    @Override
    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
