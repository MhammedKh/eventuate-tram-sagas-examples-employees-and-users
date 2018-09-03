package com.sifast.employeeandusers.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sifast.employeeandusers.users.domain.User;
import com.sifast.employeeandusers.users.domain.UserRepository;

@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.delete(userId);
    }

    public User findUser(int userId) {
        return userRepository.findOne(userId);
    }

}
