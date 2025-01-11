package com.pokeinv.events;

import com.pokeinv.View.admin.parts.forms.CardForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ChooseImageListener implements ActionListener {
    private final CardForm form;

    public ChooseImageListener(CardForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = form.getFileChooser();
        JTextField imageField = form.getImageField();
        JLabel imageLabel = form.getImageLabel();

        int returnValue = fileChooser.showOpenDialog(form);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                Image image = new ImageIcon(selectedFile.getPath()).getImage();
                Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(newImage);
                imageLabel.setIcon(scaledImage);
                imageField.setText(selectedFile.getName());

            }
        }
    }
}
