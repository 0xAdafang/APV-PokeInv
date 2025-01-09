package com.pokeinv.View.admin.parts.tables;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.Model.tables.ActionsEditor;
import com.pokeinv.Model.tables.ActionsRenderer;
import com.pokeinv.Model.tables.CardsTableModel;
import com.pokeinv.Model.tables.ImageRenderer;
import com.pokeinv.service.DataFixtures;

import javax.swing.*;
import java.util.List;

public class CardsTable extends JTable {

    public CardsTable() {

        List<Carte> cartes = DataFixtures.getCards();
        CardsTableModel model = new CardsTableModel(cartes);
        this.setModel(model);
        this.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        this.getColumnModel().getColumn(5).setCellRenderer(new ActionsRenderer());
        this.getColumnModel().getColumn(5).setCellEditor(new ActionsEditor());
        this.setRowHeight(45);

    }
}
