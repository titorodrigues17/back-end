package com.curiosity.backend.service;

import com.curiosity.backend.model.User;
import com.curiosity.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        try {String encryptedPassword = AesService.encrypt(user.getPassword());
            user.setPassword(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cifrar la contraseña.");
        }
        return userRepository.save(user);
    }

    public User getUserByAuthentication(String email, String password) {
        try {
            String encryptedPassword = AesService.encrypt(password);
            return userRepository.findByEmailAndPassword(email, encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cifrar la contraseña.");
        }
    }

}
