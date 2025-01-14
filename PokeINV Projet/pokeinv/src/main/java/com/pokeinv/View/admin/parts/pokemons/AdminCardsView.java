package com.pokeinv.View.admin.parts.pokemons;

import com.pokeinv.View.admin.AdminView;
import com.pokeinv.View.admin.parts.tables.CardsTable;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class AdminCardsView extends JPanel {

    private AdminView adminView;

    public AdminCardsView(AdminView adminView) {
        this.adminView = adminView;
        initialiserComposantsAdmin();
        setVisible(true);

    }

    private void initialiserComposantsAdmin() {

        setLayout(new BorderLayout());
        WestPanel westPanel = new WestPanel(adminView);
        CardsTable table = new CardsTable();
        JScrollPane main = new JScrollPane(table);
        main.setBorder(new MatteBorder(1, 1, 1, 1, new Color(28, 28, 51)));
        add(main, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);

    }

}
