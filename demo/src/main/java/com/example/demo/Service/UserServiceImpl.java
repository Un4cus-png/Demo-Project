package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Enums.Status;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity existingUser = getUserById(id);
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRoles(updatedUser.getRoles());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setCreatedDate(updatedUser.getCreatedDate());
        return userRepository.save(existingUser);
    }

    @Override
    public void DeleteUser(Long id) {
         userRepository.deleteById(id);
    }


}
