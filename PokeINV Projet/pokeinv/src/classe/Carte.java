public class Carte extends Inventaire {
    private String nom;
    private String collection;
    private double prix;
    private Qualite qualite;
    private Etat etat;
    private TypeCarte typeCarte;
    private Rarete rarete;
    
    public String getDetails() {
        return "Carte: " + nom + ", Collection: " + collection + ", Prix: " + prix;
    }
    
    public Qualite getQualite() {
        return qualite;
    }
    
    public Etat getEtat() {
        return etat;
    }
    
    public TypeCarte getTypeCarte() {
        return typeCarte;
    }
    
    public Rarete getRarete() {
        return rarete;
    }
}
