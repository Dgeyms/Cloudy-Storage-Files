package com.example.cloudystoragefiles.service;

import com.example.cloudystoragefiles.dto.UserDto;
import com.example.cloudystoragefiles.exception.UserAlradyExistException;
import com.example.cloudystoragefiles.model.User;
import com.example.cloudystoragefiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlradyExistException {
        if (loginExist(userDto.getLogin())) {
            throw new UserAlradyExistException("There is a user with such a login" + userDto.getLogin());
        } else {
            User user = new User();
            user.setLogin(userDto.getLogin());
            user.setPassword(user.getPassword());

            return userRepository.save(user);
        }
    }

    private Boolean loginExist(String login) {
        return userRepository.existsByLogin(login) != null;
    }

}
