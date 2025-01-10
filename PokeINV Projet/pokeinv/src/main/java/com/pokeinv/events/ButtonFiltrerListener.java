package com.pokeinv.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pokeinv.View.shared.Composants.forms.CardFiltreDialog;

public class ButtonFiltrerListener implements ActionListener {

    public ButtonFiltrerListener() {
        new CardFiltreDialog(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Filtrer")) {
            System.out.println("Filtrer clicked");
        } else if (e.getActionCommand().equals("Annuler")) {
            System.out.println("Annuler clicked");
        }
    }
}
