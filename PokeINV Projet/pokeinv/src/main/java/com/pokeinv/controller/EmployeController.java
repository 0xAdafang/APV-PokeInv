package com.pokeinv.controller;

import com.pokeinv.Model.entity.Employe;
import com.pokeinv.Model.tables.EmployesTableModel;
import com.pokeinv.service.DataFixtures;

import java.util.List;

public class EmployeController {

    private final EmployesTableModel model;

    public EmployeController() {
        this.model = EmployesTableModel.getInstance();

    }

    public static List<Employe> getAllEmployees() {
        return DataFixtures.getEmployes();
    }

    public Employe getEmployee(Long id) {
        return DataFixtures.getEmploye(id);
    }

    public Employe createEmployee(Employe employe) {
        return employe;
    }

    public void updateEmployeeRequest(Employe employe) {
    }

    public void updateEmployee(Long id, Employe employe) {
        model.fireTableDataChanged();
    }

    public void deleteEmployee(Long id) {
        DataFixtures.deleteEmploye(id);
        model.fireTableDataChanged();
    }

}
