public class Carte {
    private int idCarte;
    private String nom;
    private int collectionId;
    private double prix;
    private int qualiteId;
    private int etatId;
    private int typeCarteId;
    private int rareteId;

    public Carte() {}

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQualiteId() {
        return qualiteId;
    }

    public void setQualiteId(int qualiteId) {
        this.qualiteId = qualiteId;
    }

    public int getEtatId() {
        return etatId;
    }

    public void setEtatId(int etatId) {
        this.etatId = etatId;
    }

    public int getTypeCarteId() {
        return typeCarteId;
    }

    public void setTypeCarteId(int typeCarteId) {
        this.typeCarteId = typeCarteId;
    }

    public int getRareteId() {
        return rareteId;
    }

    public void setRareteId(int rareteId) {
        this.rareteId = rareteId;
    }
}