package com.example.validate_form_input.service;

import com.example.validate_form_input.model.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user1);
}
