package com.example.validate_form_input.repository;

import com.example.validate_form_input.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

}
