package com.tryam.study.service;

import com.tryam.study.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

    User getUser(String name);

    List<User> getUsers();

    void save(User user);

    void delete(Long id);

}