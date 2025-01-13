package com.pokeinv.controller;

import com.pokeinv.Model.entity.Employee;
import com.pokeinv.Model.tables.EmployeesTableModel;
import com.pokeinv.service.DataFixtures;

import java.util.List;

public class EmployeeController {

    private final EmployeesTableModel model;

    public EmployeeController() {
        this.model = EmployeesTableModel.getInstance();

    }

    public static List<Employee> getAllEmployees() {
        return DataFixtures.getEmployees();
    }

    public Employee getEmployee(Long id) {
        return DataFixtures.getEmployee(id);
    }

    public Employee createEmployee(Employee employee) {
        return employee;
    }

    public void updateEmployeeRequest(Employee employee) {
    }

    public void updateEmployee(Long id, Employee employee) {
        model.fireTableDataChanged();
    }

    public void deleteEmployee(Long id) {
        DataFixtures.deleteEmployee(id);
        model.fireTableDataChanged();
    }

}
