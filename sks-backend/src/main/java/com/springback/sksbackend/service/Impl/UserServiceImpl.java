package com.springback.sksbackend.service.Impl;

import com.springback.sksbackend.dto.LoginDTO;
import com.springback.sksbackend.dto.UserDTO;
import com.springback.sksbackend.entity.response.LoginResponse;
import com.springback.sksbackend.entity.User;
import com.springback.sksbackend.repository.UserRepo;
import com.springback.sksbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {

            User user = new User(
                    userDTO.getUserid(),
                    userDTO.getUserName(),
                    userDTO.getEmail(),
                    this.passwordEncoder.encode(userDTO.getPassword())
            );

            userRepo.save(user);

            return user.getUserName();
        }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {

        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if(user1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password,encodedPassword);
            if(isPasswordRight){
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Giriş Başarılı",true);
                }
                else{
                    return new LoginResponse("Giriş Başarısız",false);
                }
            }
            else {
                return new LoginResponse("Parola hatalı",false);
            }
        }
        else {
            return new LoginResponse("Email geçersiz",false);
        }
    }


}


