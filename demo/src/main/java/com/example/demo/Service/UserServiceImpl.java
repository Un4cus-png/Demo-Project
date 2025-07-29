package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
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
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return null;
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        return null;
    }

    @Override
    public void softDeleteUser(Long id) {

    }


}
