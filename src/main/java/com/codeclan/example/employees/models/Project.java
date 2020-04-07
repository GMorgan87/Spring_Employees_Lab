package com.codeclan.example.employees.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int numberOfDays;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="projects_employees",
            joinColumns = {
                    @JoinColumn(
                            name="project_id",
                            nullable = false,
                            updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="employee_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Employee> employees;

    public Project(String name, int numberOfDays){
        this.name = name;
        this.numberOfDays = numberOfDays;
        this.employees = new ArrayList<>();
    }

    public Project(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
