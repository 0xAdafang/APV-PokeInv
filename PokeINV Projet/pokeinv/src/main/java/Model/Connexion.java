package Model;
import java.util.Date;

public class Connexion {
    private String courriel;
    private String motDePasse;
    private String statut;
    private Date dateConnexion;
    
    public boolean verifierStatut() {
        return "actif".equals(statut);
    }
    
    public String getDetailsConnexion() {
        return "Courriel: " + courriel + ", Statut: " + statut + ", Date: " + dateConnexion + "motDePasse" + motDePasse;
    }
}