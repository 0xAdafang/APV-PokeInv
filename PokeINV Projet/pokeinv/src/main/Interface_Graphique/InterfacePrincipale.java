package Interface_Graphique;

import javax.swing.*;

import Interface_Graphique.Composants.parts.NorthPanel;

import java.awt.*;
import java.io.*;
import java.util.*;

public class InterfacePrincipale extends JFrame {

    public InterfacePrincipale() throws IOException {
        setTitle("PokeINV");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // seticon
        setLocationRelativeTo(null);
        initialiserComposants();
        setVisible(true);
    }

    private void initialiserComposants() throws IOException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(28, 28, 51));

        NorthPanel northPanel = new NorthPanel();
        mainPanel.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        centerPanel.setBackground(new Color(28, 28, 51));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
    }
}