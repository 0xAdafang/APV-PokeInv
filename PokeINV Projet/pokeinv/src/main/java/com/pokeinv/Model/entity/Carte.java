package com.pokeinv.Model.entity;

public class Carte {
    private Long id;
    private String name;
    private Collection collection;
    private double price;
    private GradePSA gradePSA;
    private Etat etat;
    private TypeCarte typeCarte;
    private Rarete rarete;

    public Carte(Long id, String name, Collection collection, double price, GradePSA gradePSA, Etat etat, TypeCarte typeCarte, Rarete rarete) {
        this.id = id;
        this.name = name;
        this.collection = collection;
        this.price = price;
        this.gradePSA = gradePSA;
        this.etat = etat;
        this.typeCarte = typeCarte;
        this.rarete = rarete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GradePSA getGradePSA() {
        return gradePSA;
    }

    public void setGradePSA(GradePSA gradePSA) {
        this.gradePSA = gradePSA;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public TypeCarte getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(TypeCarte typeCarte) {
        this.typeCarte = typeCarte;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collection=" + collection +
                ", price=" + price +
                ", gradePSA=" + gradePSA +
                ", etat=" + etat +
                ", typeCarte=" + typeCarte +
                ", rarete=" + rarete +
                '}';
    }
}
