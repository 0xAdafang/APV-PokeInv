import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Carte> cartes;
    
    public void ajouterCarte(Carte carte) {
        if (cartes == null) {
            cartes = new ArrayList<>();
        }
        cartes.add(carte);
    }
    
    public int compterCartesParType(TypeCarte typeRecherche) {
        return (int) cartes.stream()
            .filter(carte -> carte.getTypeCarte().equals(typeRecherche))
            .count();
    }
    
    public int compterTotalCartes() {
        return cartes != null ? cartes.size() : 0;
    }
}
