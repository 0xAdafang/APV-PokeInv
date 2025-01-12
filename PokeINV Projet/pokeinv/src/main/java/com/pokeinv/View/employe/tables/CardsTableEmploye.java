package com.pokeinv.View.employe.tables;

import com.pokeinv.Model.entity.Carte;
import com.pokeinv.controller.CardController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.*;

public class CardsTableEmploye extends JPanel {

    public CardsTableEmploye() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(28, 28, 51));

        // North Panel
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("Liste des cartes");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 10));
        northPanel.add(title);
        northPanel.setBackground(new Color(12, 13, 30));
        this.add(northPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(28, 28, 51));
        centerPanel.add(createContainerPanel(), BorderLayout.CENTER);

        this.add(centerPanel, BorderLayout.CENTER);

    }

    private JScrollPane createContainerPanel() {
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0, 5, 10, 10));
        containerPanel.setBackground(new Color(28, 28, 51));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        List<Carte> cards = CardController.getAllCards();

        for (Carte card : cards) {
            containerPanel.add(createCardPanel(card));
        }

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.getViewport().setBackground(new Color(28, 28, 51));
        scrollPane.getHorizontalScrollBar().setBackground(new Color(28, 28, 51));
        scrollPane.getVerticalScrollBar().setBackground(new Color(50, 50, 50));

        scrollPane.setBorder(BorderFactory.createLineBorder(getBackground(), 1));

        return scrollPane;
    }

    private JPanel createCardPanel(Carte card) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBackground(new Color(13, 13, 30));

        // image card
        String imagePath = "/pokemons/" + card.getImage();
        URL imageUrl = getClass().getResource(imagePath);

        if (imageUrl == null) {
            System.out.println("Image not found: " + imagePath);
            return null;
        } else {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(
                    250, 250,
                    Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            cardPanel.add(imageLabel, BorderLayout.CENTER);
        }

        // info card
        JLabel infoLabel = new JLabel(
                "<html>" +
                        "<strong>Nom:</strong> " + card.getName() + "<br>" +
                        "<strong>Collection:</strong> " + card.getCollection().getName() + "<br><br><br>" +
                        "<strong>GradePSA:</strong> " + card.getGradePSA() + "<br>" +
                        "<strong>Etat:</strong> " + card.getEtat() + "<br>" +
                        "<strong>Prix:</strong> " + card.getPrice() + "$" +
                        "</html>");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // info wrapper
        JPanel infoWrapper = new JPanel();
        infoWrapper.setLayout(new BorderLayout());
        infoWrapper.add(infoLabel, BorderLayout.CENTER);
        infoWrapper.setBackground(new Color(13, 13, 30));
        infoWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ajouter les composants au panel

        cardPanel.add(infoWrapper, BorderLayout.SOUTH);

        return cardPanel;
    }
}
