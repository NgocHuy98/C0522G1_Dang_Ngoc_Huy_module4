package com.example.furama_system.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;


    public Position() {
    }

    public Position(int id, String name, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.employeeSet = employeeSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
