package com.willcocks.callum.service;

import com.willcocks.callum.HibernateConfiguration;
import com.willcocks.callum.model.Employee;
import com.willcocks.callum.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;
import java.util.UUID;

public class EmployeeService {
    private final SessionFactory sessionFactory;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(SessionFactory sessionFactory, EmployeeRepository employeeRepository) {
        this.sessionFactory = sessionFactory;
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        employeeRepository.save(employee);
        tx.commit();
    }

    public void delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        employeeRepository.delete(employee);
        tx.commit();
    }

    public void delete(UUID employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        employeeRepository.delete(employee);
        tx.commit();
    }

    public Optional<Employee> findEmployeeWithId(UUID uuid) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Optional<Employee> employee = employeeRepository.findEmployeeWithId(uuid);
        tx.commit();

        return employee;
    }
}
