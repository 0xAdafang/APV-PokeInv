package com.pokeinv.View.employe.tables;

import com.pokeinv.Model.tables.ActionsEditor;
import com.pokeinv.Model.tables.ActionsRenderer;
import com.pokeinv.Model.tables.CardsTableModel;
import com.pokeinv.Model.tables.ImageRenderer;
import com.pokeinv.controller.CardController;

import javax.swing.*;

public class CardsTable extends JTable {

    public CardsTable() {
        CardsTableModel model = CardsTableModel.getInstance();
        CardController cardController = new CardController();
        this.setModel(model);
        this.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        this.getColumnModel().getColumn(6).setCellRenderer(new ActionsRenderer());
        this.getColumnModel().getColumn(6).setCellEditor(new ActionsEditor(cardController));
        this.setRowHeight(45);

    }
}
