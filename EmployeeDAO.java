package com.ems.dao;

import com.ems.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void save(Employee emp);
    void update(Employee emp);
    void delete(int id);
    Employee getById(int id);
    List<Employee> getAll();
}
