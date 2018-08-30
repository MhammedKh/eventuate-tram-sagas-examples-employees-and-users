package com.sifast.employeeandusers.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sifast.employeeandusers.users.domain.User;
import com.sifast.employeeandusers.users.domain.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }

}
