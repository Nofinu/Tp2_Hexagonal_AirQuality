package com.example.infrastructure.repository.impl;

import com.example.infrastructure.entity.UserEntity;
import com.example.infrastructure.repository.UserEntityRepository;
import org.example.entity.User;
import org.example.spi.port.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private ModelMapper modelMapper;

    private UserEntityRepository userEntityRepository;

    public UserRepositoryImpl(UserEntityRepository userEntityRepository) {
        modelMapper =new ModelMapper();
        this.userEntityRepository =  userEntityRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        return modelMapper.map(userEntityRepository.save(userEntity), User.class) ;
    }

    @Override
    public User findByUsername(String username) {
        return modelMapper.map(userEntityRepository.findByUsername(username), User.class);
    }
}
