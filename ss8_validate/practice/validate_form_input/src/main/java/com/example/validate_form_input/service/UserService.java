package com.example.validate_form_input.service;

import com.example.validate_form_input.model.User;
import com.example.validate_form_input.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user1) {
        iUserRepository.save(user1);
    }
}
