package com.example.cloudystoragefiles.service;

import com.example.cloudystoragefiles.model.User;
import com.example.cloudystoragefiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUserInDatabase(User user) {
        userRepository.save(user);
    }

}
