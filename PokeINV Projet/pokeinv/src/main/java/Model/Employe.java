package Model;
import java.util.Date;

public class Employe extends Connexion {
    private String nom;
    private String prenom;
    private String role;
    private Date dateEmbauche;
    
    public String getDetailsEmploye() {
        return "Employé: " + prenom + " " + nom + ", Rôle: " + role + ", Date d'embauche: " + dateEmbauche;
    }
}