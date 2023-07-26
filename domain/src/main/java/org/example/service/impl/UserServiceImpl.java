package org.example.service.impl;

import org.example.entity.User;
import org.example.spi.adapter.UserService;
import org.example.spi.port.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User create(String username, String password) {
        User user = new User(username,password);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
