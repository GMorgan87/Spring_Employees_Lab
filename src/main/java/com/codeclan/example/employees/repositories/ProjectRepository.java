package com.codeclan.example.employees.repositories;

import com.codeclan.example.employees.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
