package com.pokeinv.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pokeinv.View.shared.Composants.forms.CardAjouteDialog;

public class ButtonAjouteListener implements ActionListener {

    public ButtonAjouteListener() {
        new CardAjouteDialog(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Valider")) {
            System.out.println("Valider clicked");

        } else if (e.getActionCommand().equals("Annuler")) {
            System.out.println("Annuler clicked");
        }
    }
}
