package com.pokeinv.View.admin.parts.tables;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.tables.*;
import com.pokeinv.controller.CardController;
import com.pokeinv.service.DataFixtures;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CardsTable extends JTable {

    public CardsTable() {
        List<Carte> cartes = DataFixtures.getCards();
        CardsTableModel model = new CardsTableModel(cartes);
        CardController cardController = new CardController(model);
        this.setModel(model);
        this.getColumnModel().getColumn(0).setMaxWidth(50);
        this.getColumnModel().getColumn(1).setMaxWidth(50);
        this.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        this.getColumnModel().getColumn(8).setCellRenderer(new ActionsRenderer());
        this.getColumnModel().getColumn(8).setCellEditor(new ActionsEditor(cardController));
        this.setRowHeight(45);
        this.setDefaultRenderer(Object.class, new TableRenderer());
        this.setBackground(new Color(19, 19, 38));
        this.setSelectionBackground(new Color(38, 38, 65));
        this.setForeground(new Color(204, 204, 204));
        this.setSelectionForeground(new Color(204, 204, 204));
        this.tableHeader.setBackground(new Color(28, 28, 51));
        this.tableHeader.setForeground(new Color(204, 204, 204));
        this.tableHeader.setDefaultRenderer(new HeaderRenderer());

    }


}
