package bo;

public class Couleur {
    String nomCouleur;
    String hexaCouleur;


    public Couleur(String nomCouleur, String hexaCouleur) {
        this.nomCouleur = nomCouleur;
        this.hexaCouleur = hexaCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    public String getHexaCouleur() {
        return hexaCouleur;
    }

    public void setHexaCouleur(String hexaCouleur) {
        this.hexaCouleur = hexaCouleur;
    }
}
