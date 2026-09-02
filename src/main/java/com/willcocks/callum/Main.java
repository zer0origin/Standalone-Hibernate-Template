package com.willcocks.callum;

import com.willcocks.callum.model.Employee;
import com.willcocks.callum.repository.EmployeeRepository;
import com.willcocks.callum.service.EmployeeService;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class Main {
    static void main() {
        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        hibernateConfiguration.setUpHibernate("jdbc:mysql://localhost:3306/example", "root", "password", Employee.class);

        SessionFactory sessionFactory = hibernateConfiguration.getSessionFactory();
        EmployeeRepository employeeRepository = new EmployeeRepository(sessionFactory);
        EmployeeService employeeService = new EmployeeService(sessionFactory, employeeRepository);

        Employee johnDoe = new Employee(UUID.fromString("383dfa89-f136-4563-9534-4ea1f280e8a4"), "John Doe");
        employeeService.save(johnDoe);
    }
}
