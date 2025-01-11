package com.pokeinv.service;

import com.pokeinv.Model.entity.*;
import com.pokeinv.View.admin.parts.forms.CardForm;

public class FormValidator {

    private final CardForm form;

    public FormValidator(CardForm form) {

        this.form = form;
    }

    public Carte getValidatedCard() {
        if (form.getNameField().getText().isBlank()) {
            throw new IllegalArgumentException("Le champs nom de la carte est obligatoire");
        }
        if (form.getPriceField().getText().isBlank()) {
            throw new IllegalArgumentException("Le champs prix est obligatoire");
        }

        try {
            Double.parseDouble(form.getPriceField().getText());
        } catch (Exception e) {
            throw new IllegalArgumentException("Le champs prix doit être un nombre valide");
        }

        if (form.getCollectionField().getSelectedItem() == null) {
            throw new IllegalArgumentException("Le champs collection est obligatoire");
        }
        if (form.getTypeField().getSelectedItem() == null) {
            throw new IllegalArgumentException("Le champs Type est obligatoire");
        }
        if (form.getRareteField().getSelectedItem() == null) {
            throw new IllegalArgumentException("Le champs Rareté est obligatoire");
        }
        if (form.getGradeField().getSelectedItem() == null) {
            throw new IllegalArgumentException("Le champs Rareté est obligatoire");
        }
        if (form.getEtatField().getSelectedItem() == null) {
            throw new IllegalArgumentException("Le champs État est obligatoire");
        }
        if (form.getImageField().getText().isBlank()) {
            throw new IllegalArgumentException("Insérez une image à la carte");
        }

        return new Carte(
                null,
                form.getNameField().getText(),
                (Collection) form.getCollectionField().getSelectedItem(),
                Double.parseDouble(form.getPriceField().getText()),
                (GradePSA) form.getGradeField().getSelectedItem(),
                (Etat) form.getEtatField().getSelectedItem(),
                (TypeCarte) form.getTypeField().getSelectedItem(),
                (Rarete) form.getRareteField().getSelectedItem(),
                form.getImageField().getText());

    }
}
