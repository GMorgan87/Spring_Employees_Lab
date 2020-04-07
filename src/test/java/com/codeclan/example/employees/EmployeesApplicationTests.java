package com.codeclan.example.employees;

import com.codeclan.example.employees.models.Department;
import com.codeclan.example.employees.models.Employee;
import com.codeclan.example.employees.models.Project;
import com.codeclan.example.employees.repositories.DepartmentRepository;
import com.codeclan.example.employees.repositories.EmployeeRepository;
import com.codeclan.example.employees.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeesApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployeeAndDepartment(){
		Department department = new Department("Department");
		departmentRepository.save(department);

		Employee employee = new Employee("Bob", "LastName", 007, department);
		employeeRepository.save(employee);
	}

	@Test
	public void canCreateEmployeesAndProjects(){
		Department department = new Department("Department");
		departmentRepository.save(department);

		Employee employee = new Employee("Bob", "LastName", 007, department);
		employeeRepository.save(employee);

		Project project = new Project("project", 5);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);
	}

}
