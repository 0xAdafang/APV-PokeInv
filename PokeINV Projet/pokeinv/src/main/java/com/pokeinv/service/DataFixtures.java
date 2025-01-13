package com.pokeinv.service;

import com.pokeinv.Model.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DataFixtures {

    public static List<Carte> cartes;
    public static List<Collection> collections;

    public static List<Carte> getCards() {

        cartes = new ArrayList<>();
        collections = new ArrayList<>();

        Collection baseSet = new Collection(1L, "Base Set");
        Collection baseSet2 = new Collection(1L, "Base Set 2");
        Collection jungle = new Collection(2L, "Jungle");
        Collection fossil = new Collection(3L, "Fossil");
        Collection teamRocket = new Collection(5L, "Team Rocket");
        Collection unifiedMinds = new Collection(6L, "Unified Minds");
        Collection blackAndWhite = new Collection(7L, "Black and White");
        collections.add(baseSet);
        collections.add(baseSet2);
        collections.add(jungle);
        collections.add(fossil);
        collections.add(teamRocket);
        cartes.add(new Carte(1L, "Pikachu", baseSet, 150.0, GradePSA.PSA10, Etat.Mint, TypeCarte.LIGHTENING,
                Rarete.Rare, "pikachu.jpg"));
        cartes.add(new Carte(2L, "Charizard", baseSet, 2500.0, GradePSA.PSA9, Etat.NearMint, TypeCarte.FIRE,
                Rarete.SecretRare, "charizard.jpg"));
        cartes.add(new Carte(3L, "Bulbasaur", baseSet, 120.0, GradePSA.PSA8, Etat.Excellent, TypeCarte.GRASS,
                Rarete.Common, "bulbasaur.jpg"));
        cartes.add(new Carte(4L, "Squirtle", baseSet, 100.0, GradePSA.PSA7, Etat.Good, TypeCarte.WATER, Rarete.Uncommon,
                "squirtle.jpg"));
        cartes.add(new Carte(5L, "Eevee", jungle, 180.0, GradePSA.PSA10, Etat.Mint, TypeCarte.COLORLESS,
                Rarete.HoloRare, "eevee.jpg"));
        cartes.add(new Carte(6L, "Mewtwo", fossil, 300.0, GradePSA.PSA9, Etat.Excellent, TypeCarte.PSYCHIC,
                Rarete.UltraRare, "mewtwo.jpg"));
        cartes.add(new Carte(7L, "Gengar", fossil, 500.0, GradePSA.PSA8, Etat.NearMint, TypeCarte.DARK,
                Rarete.SecretArtIllustration, "gengar.jpg"));
        cartes.add(new Carte(8L, "Machamp", baseSet2, 200.0, GradePSA.PSA7, Etat.Good, TypeCarte.FIGHTING, Rarete.Rare,
                "machamp.jpg"));
        cartes.add(new Carte(9L, "Dragonite", teamRocket, 1000.0, GradePSA.PSA6, Etat.LightlyPlayed, TypeCarte.DRAGON,
                Rarete.SecretRare, "dragonite.jpg"));
        cartes.add(new Carte(10L, "Jigglypuff", jungle, 50.0, GradePSA.PSA5, Etat.Poor, TypeCarte.FAIRY,
                Rarete.Common, "jigglypuff.jpg"));
        cartes.add(new Carte(11L, "Raichu Alolan", unifiedMinds, 150.0, GradePSA.PSA10, Etat.Mint, TypeCarte.LIGHTENING,
                Rarete.Rare, "raichuAlolan.jpg"));
        cartes.add(new Carte(12L, "Zekrom", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NearMint, TypeCarte.DRAGON,
                Rarete.SecretArtIllustration, "zekrom.jpg"));
        cartes.add(new Carte(11L, "Raichu Alolan", unifiedMinds, 150.0, GradePSA.PSA10, Etat.Mint, TypeCarte.LIGHTENING,
                Rarete.Rare, "raichuAlolan.jpg"));
        cartes.add(new Carte(12L, "Zekrom", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NearMint, TypeCarte.DRAGON,
                Rarete.SecretArtIllustration, "zekrom.jpg"));
        cartes.add(new Carte(13L, "Reshiram", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NearMint, TypeCarte.DRAGON,
                Rarete.SecretArtIllustration, "reshiram.jpg"));
        return cartes;
    }

    public static List<Collection> getCollections() {
        if (cartes.isEmpty()) {
            cartes = getCards();
        }
        return collections;
    }

    public static List<Employe> getEmployes() {
        List<Employe> employees = new ArrayList<>();

        // Adding 5 employees to the list
        employees.add(new Employe(1L, "John", "Doe", new Date(122, 5, 15))); // Hire date: 15 June 2022
        employees.add(new Employe(2L, "Jane", "Smith", new Date(120, 3, 10))); // Hire date: 10 April 2020
        employees.add(new Employe(3L, "Mike", "Brown", new Date(118, 1, 25))); // Hire date: 25 February 2018
        employees.add(new Employe(4L, "Emily", "Davis", new Date(121, 8, 5))); // Hire date: 5 September 2021
        employees.add(new Employe(5L, "James", "Wilson", new Date(123, 10, 20))); // Hire date: 20 November 2023

        return employees;
    }

    public static Carte getCard(int id) {
        for (Carte card : cartes) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public static Employe getEmploye(Long id) {
        for (Employe employee : getEmployes()) {
            if (Objects.equals(employee.getId(), id)) {
                return employee;
            }
        }
        return null;
    }

    public static void deleteCard(Long id) {
        cartes.removeIf(card -> Objects.equals(card.getId(), id));
    }

    public static void deleteEmploye(Long id) {
        getEmployes().removeIf(employe -> Objects.equals(employe.getId(), id));
    }

    public static void updateCard(Long id, Carte card) {
        for (int i = 0; i < cartes.size(); i++) {
            if (cartes.get(i).getId().equals(id)) {
                card.setId(id);
                cartes.set(i, card);
                break;
            }
        }
    }


}
