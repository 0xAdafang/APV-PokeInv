package com.pokeinv.Model.tables;

import com.pokeinv.Model.entity.Employee;
import com.pokeinv.View.admin.components.buttons.DeleteButton;
import com.pokeinv.View.admin.components.buttons.EditButton;
import com.pokeinv.controller.EmployeeController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeActionsEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton update;
    private final JButton delete;
    private final JPanel panel = new JPanel();
    private final EmployeeController employeeController;
    private EmployeesTableModel model;
    private int rowIndex;
    private Color backgroudSelection;

    public EmployeeActionsEditor(EmployeeController employeeController) {
        this.employeeController = employeeController;
        update = new EditButton();
        delete = new DeleteButton();
        panel.add(update);
        panel.add(delete);
        Border matteBorder = new MatteBorder(0, 0, 2, 0, new Color(3, 22, 38));
        Border emptyBorder = new EmptyBorder(5, 20, 5, 5);
        Border compoundBorder = new CompoundBorder(matteBorder, emptyBorder);
        panel.setBorder(compoundBorder);
        initActions();
        initMouseListener();

    }

    private void initActions() {
        update.addActionListener(e -> {
            panel.setBackground(backgroudSelection);
            Employee employee = model.getEmployeeAt(rowIndex);
            employeeController.updateEmployeeRequest(employee);
        });
        delete.addActionListener(e -> {
            panel.setBackground(backgroudSelection);
            Employee employee = model.getEmployeeAt(rowIndex);
            employeeController.deleteEmployee(employee.getId());

        });
    }

    private void initMouseListener() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panel.setBackground(backgroudSelection);
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.model = (EmployeesTableModel) table.getModel();
        this.rowIndex = table.convertRowIndexToModel(row);
        this.backgroudSelection = table.getSelectionBackground();
        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
