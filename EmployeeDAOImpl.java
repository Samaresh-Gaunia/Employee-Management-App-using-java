package com.ems.dao;

import com.ems.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Employee emp) {
        sessionFactory.getCurrentSession().save(emp);
    }

    public void update(Employee emp) {
        sessionFactory.getCurrentSession().update(emp);
    }

    public void delete(int id) {
        Employee emp = getById(id);
        if (emp != null) {
            sessionFactory.getCurrentSession().delete(emp);
        }
    }

    public Employee getById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession()
            .createQuery("from Employee", Employee.class).list();
    }
}
