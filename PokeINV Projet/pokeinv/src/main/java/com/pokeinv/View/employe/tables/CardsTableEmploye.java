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
        this.setLayout(new GridLayout(0, 6, 3, 3));
        this.setBackground(new Color(28, 28, 51));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        List<Carte> cards = CardController.getAllCards();

        for (Carte card : cards) {
            this.add(createCardPanel(card));
        }
    }

    private JPanel createCardPanel(Carte card) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cardPanel.setBackground(new Color(28, 28, 51));

        // image card
        String imagePath = "/pokemons/" + card.getImage();
        URL imageUrl = getClass().getResource(imagePath);

        if (imageUrl == null) {
            System.out.println("Image not found: " + imagePath);
            return null;
        } else {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
            cardPanel.add(imageLabel, BorderLayout.CENTER);
        }

        // info card
        JLabel infoLabel = new JLabel(
                "<html>" +
                        "<strong>Nom:</strong> " + card.getName() + "<br>" +
                        "<strong>Collection:</strong> " + card.getCollection().getName() + "<br>" +
                        "<strong>GradePSA:</strong> " + card.getGradePSA() + "<br>" +
                        "<strong>Etat:</strong> " + card.getEtat() + "<br>" +
                        "<strong>Prix:</strong> " + card.getPrice() + "$" +
                        "</html>");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));

        // info wrapper
        JPanel infoWrapper = new JPanel();
        infoWrapper.setLayout(new BorderLayout());
        infoWrapper.add(infoLabel, BorderLayout.CENTER);
        infoWrapper.setBackground(new Color(28, 28, 51));
        infoWrapper.setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0));

        // ajouter les composants au panel

        cardPanel.add(infoWrapper, BorderLayout.SOUTH);

        return cardPanel;
    }
}
