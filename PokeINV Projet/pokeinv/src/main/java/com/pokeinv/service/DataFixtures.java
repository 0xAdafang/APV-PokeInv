package com.pokeinv.service;

import com.pokeinv.Model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataFixtures {

    public static List<Carte> cartes = new ArrayList<>();
    public static List<Collection> collections = new ArrayList<>();

    public static List<Carte> getCards() {

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
        cartes.add(new Carte(1L, "Pikachu", baseSet, 150.0, GradePSA.PSA10, Etat.MINT, TypeCarte.LIGHTENING,
                Rarete.RARE, "pikachu.jpg"));
        cartes.add(new Carte(2L, "Charizard", baseSet, 2500.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.FIRE,
                Rarete.SECRET_RARE, "charizard.jpg"));
        cartes.add(new Carte(3L, "Bulbasaur", baseSet, 120.0, GradePSA.PSA8, Etat.EXCELLENT, TypeCarte.GRASS,
                Rarete.COMMON, "bulbasaur.jpg"));
        cartes.add(new Carte(4L, "Squirtle", baseSet, 100.0, GradePSA.PSA7, Etat.GOOD, TypeCarte.WATER, Rarete.UNCOMMON,
                "squirtle.jpg"));
        cartes.add(new Carte(5L, "Eevee", jungle, 180.0, GradePSA.PSA10, Etat.MINT, TypeCarte.COLORLESS,
                Rarete.HOLO_RARE, "eevee.jpg"));
        cartes.add(new Carte(6L, "Mewtwo", fossil, 300.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.PSYCHIC,
                Rarete.ULTRA_RARE, "mewtwo.jpg"));
        cartes.add(new Carte(7L, "Gengar", fossil, 500.0, GradePSA.PSA8, Etat.EXCELLENT, TypeCarte.DARK,
                Rarete.SECRET_ART_ILLUSTRATION, "gengar.jpg"));
        cartes.add(new Carte(8L, "Machamp", baseSet2, 200.0, GradePSA.PSA7, Etat.GOOD, TypeCarte.FIGHTING, Rarete.RARE,
                "machamp.jpg"));
        cartes.add(new Carte(9L, "Dragonite", teamRocket, 1000.0, GradePSA.PSA6, Etat.LIGHTLY_PLAYED, TypeCarte.DRAGON,
                Rarete.SECRET_RARE, "dragonite.jpg"));
        cartes.add(new Carte(10L, "Jigglypuff", jungle, 50.0, GradePSA.PSA5, Etat.PLAYED, TypeCarte.FAIRY,
                Rarete.COMMON, "jigglypuff.jpg"));
        cartes.add(new Carte(11L, "Raichu Alolan", unifiedMinds, 150.0, GradePSA.PSA10, Etat.MINT, TypeCarte.LIGHTENING,
                Rarete.RARE, "raichuAlolan.jpg"));
        cartes.add(new Carte(12L, "Zekrom", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.DRAGON,
                Rarete.SECRET_ART_ILLUSTRATION, "zekrom.jpg"));
        cartes.add(new Carte(11L, "Raichu Alolan", unifiedMinds, 150.0, GradePSA.PSA10, Etat.MINT, TypeCarte.LIGHTENING,
                Rarete.RARE, "raichuAlolan.jpg"));
        cartes.add(new Carte(12L, "Zekrom", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.DRAGON,
                Rarete.SECRET_ART_ILLUSTRATION, "zekrom.jpg"));
        cartes.add(new Carte(13L, "Reshiram", blackAndWhite, 2000.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.DRAGON,
                Rarete.SECRET_ART_ILLUSTRATION, "reshiram.jpg"));
        return cartes;
    }

    public static List<Collection> getCollections() {
        if (cartes.isEmpty()) {
            cartes = getCards();
        }
        return collections;
    }

    public static Carte getCard(int id) {
        for (Carte card : cartes) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public static void deleteCard(Long id) {
        cartes.removeIf(card -> Objects.equals(card.getId(), id));
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
