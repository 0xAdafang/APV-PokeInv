package com.pokeinv.service;

import com.pokeinv.Model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DataFixtures {

    public static List<Carte> getCards() {
        List<Carte> cartes = new ArrayList<>();

        cartes.add(new Carte(1L, "Pikachu", new Collection(1L, "Base Set"), 150.0, GradePSA.PSA10, Etat.MINT, TypeCarte.LIGHTENING, Rarete.RARE));
        cartes.add(new Carte(2L, "Charizard", new Collection(1L, "Base Set"), 2500.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.FIRE, Rarete.SECRET_RARE));
        cartes.add(new Carte(3L, "Bulbasaur", new Collection(1L, "Base Set"), 120.0, GradePSA.PSA8, Etat.EXCELLENT, TypeCarte.GRASS, Rarete.COMMON));
        cartes.add(new Carte(4L, "Squirtle", new Collection(1L, "Base Set"), 100.0, GradePSA.PSA7, Etat.GOOD, TypeCarte.WATER, Rarete.UNCOMMON));
        cartes.add(new Carte(5L, "Eevee", new Collection(2L, "Jungle"), 180.0, GradePSA.PSA10, Etat.MINT, TypeCarte.COLORLESS, Rarete.HOLO_RARE));
        cartes.add(new Carte(6L, "Mewtwo", new Collection(3L, "Fossil"), 300.0, GradePSA.PSA9, Etat.NEAR_MINT, TypeCarte.PSYCHIC, Rarete.ULTRA_RARE));
        cartes.add(new Carte(7L, "Gengar", new Collection(3L, "Fossil"), 500.0, GradePSA.PSA8, Etat.EXCELLENT, TypeCarte.DARK, Rarete.SECRET_ART_ILLUSTRATION));
        cartes.add(new Carte(8L, "Machamp", new Collection(4L, "Base Set 2"), 200.0, GradePSA.PSA7, Etat.GOOD, TypeCarte.FIGHTING, Rarete.RARE));
        cartes.add(new Carte(9L, "Dragonite", new Collection(5L, "Team Rocket"), 1000.0, GradePSA.PSA6, Etat.LIGHTLY_PLAYED, TypeCarte.DRAGON, Rarete.SECRET_RARE));
        cartes.add(new Carte(10L, "Jigglypuff", new Collection(2L, "Jungle"), 50.0, GradePSA.PSA5, Etat.PLAYED, TypeCarte.FAIRY, Rarete.COMMON));

        return cartes;
    }
}
