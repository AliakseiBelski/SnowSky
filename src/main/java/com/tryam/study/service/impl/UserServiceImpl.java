package com.tryam.study.service.impl;

import com.tryam.study.entity.User;
import com.tryam.study.repository.UserRepository;
import com.tryam.study.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            userRepository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}