import javax.swing.*;
import java.awt.*;

public class PanneauJeu extends JPanel{
    private FenetrePrincipal fenetre;
    private Grille grille;

    public PanneauJeu(FenetrePrincipal fenetre, int lignes, int colonnes){
        this.fenetre = fenetre;
        this.setLayout(new BorderLayout());

        grille = new Grille(lignes, colonnes, 10);
        add(grille.afficherGrille(), BorderLayout.CENTER);
    }
}