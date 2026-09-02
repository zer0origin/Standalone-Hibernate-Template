package com.willcocks.callum.repository;

import com.willcocks.callum.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.UUID;

public class EmployeeRepository {
    private final SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Employee employee){
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    public void delete(Employee employee){
        Session session = sessionFactory.getCurrentSession();
        session.remove(employee);
    }

    public void delete(UUID employee){
        Session session = sessionFactory.getCurrentSession();

        Employee ref = session.getReference(Employee.class, employee);
        session.remove(ref);
    }

    public Optional<Employee> findEmployeeWithId(UUID uuid){
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.find(Employee.class, uuid);
        return Optional.ofNullable(employee);
    }
}
