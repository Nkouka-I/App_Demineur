import javax.swing.*;
import java.awt.*;

public class PanneauJeu extends JPanel{
    private FenetrePrincipal fenetre;
    private Grille grille;

    public PanneauJeu(FenetrePrincipal fenetre, int lignes, int colonnes, int mines){
        this.fenetre = fenetre;
        this.setLayout(new BorderLayout());

        grille = new Grille(lignes, colonnes, mines);
        add(grille.afficherGrille(), BorderLayout.CENTER);
    }
}