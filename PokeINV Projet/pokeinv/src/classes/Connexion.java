import java.sql.Date;

public class Connexion {
    private int idConnexion;
    private String courriel;
    private String motDePasse;
    private String status;
    private Date dateConnexion;

    public Connexion() {}

    public int getIdConnexion() {
        return idConnexion;
    }

    public void setIdConnexion(int idConnexion) {
        this.idConnexion = idConnexion;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateConnexion = dateConnexion;
    }
}
