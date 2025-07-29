package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);
    UserEntity updateUser(Long id, UserEntity user);
    void softDeleteUser(Long id);
}
