package com.arcade.service;

import com.arcade.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    List<User> findByName(String name);
}
