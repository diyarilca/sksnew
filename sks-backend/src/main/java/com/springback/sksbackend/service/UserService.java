package com.springback.sksbackend.service;

import com.springback.sksbackend.dto.LoginDTO;
import com.springback.sksbackend.dto.UserDTO;
import com.springback.sksbackend.entity.response.LoginResponse;


public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
