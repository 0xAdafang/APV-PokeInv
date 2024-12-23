public class Rarete {
    private int idRarete;
    private String niveauRarete; // COMMUN, UNCOMMON, RARE, HOLO_RARE, ULTRA_RARE, SECRET_RARE, SECRET_ART_ILLUSTRATION

    public Rarete() {}

    public int getIdRarete() {
        return idRarete;
    }

    public void setIdRarete(int idRarete) {
        this.idRarete = idRarete;
    }

    public String getNiveauRarete() {
        return niveauRarete;
    }

    public void setNiveauRarete(String niveauRarete) {
        this.niveauRarete = niveauRarete;
    }
}