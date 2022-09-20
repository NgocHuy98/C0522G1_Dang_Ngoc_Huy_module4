package com.example.validate_form.repository;
import com.example.validate_form.model.Validator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IValidateRepository extends JpaRepository<Validator,Integer> {

}
