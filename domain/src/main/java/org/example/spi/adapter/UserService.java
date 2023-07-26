package org.example.spi.adapter;

import org.example.entity.User;

public interface UserService {
    User create (String username,String password);
    User findByUsername (String username);
}
