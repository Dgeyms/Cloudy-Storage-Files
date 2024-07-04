package com.example.cloudystoragefiles.service;

import com.example.cloudystoragefiles.dto.UserDto;
import com.example.cloudystoragefiles.model.User;

public interface IUserService {

    User registerNewUserAccount(UserDto userDto);
}
