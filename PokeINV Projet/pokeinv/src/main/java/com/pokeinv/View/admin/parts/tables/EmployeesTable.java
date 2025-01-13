package com.pokeinv.View.admin.parts.tables;

import com.pokeinv.Model.tables.*;
import com.pokeinv.controller.EmployeeController;

import javax.swing.*;
import java.awt.*;

public class EmployeesTable extends JTable {

    public EmployeesTable() {

        EmployeesTableModel model = EmployeesTableModel.getInstance();
        EmployeeController employeeController = new EmployeeController();
        this.setModel(model);

        this.getColumnModel().getColumn(4).setCellRenderer(new EmployeeActionsRenderer());
        this.getColumnModel().getColumn(4).setCellEditor(new EmployeeActionsEditor(employeeController));
        this.setRowHeight(45);
        this.setDefaultRenderer(Object.class, new TableRenderer());
        this.setBackground(new Color(0, 26, 47));
        this.setSelectionBackground(new Color(38, 38, 65, 100));
        this.setForeground(new Color(204, 204, 204));
        this.setSelectionForeground(new Color(204, 204, 204));
        this.tableHeader.setBackground(new Color(28, 28, 51));
        this.tableHeader.setForeground(new Color(204, 204, 204));
        this.tableHeader.setDefaultRenderer(new HeaderRenderer());

    }


}
