package com.arcade;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);
}
