import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsommateurConfig implements ActionListener{
	private PanneauConfig panneau;
    private FenetrePrincipal fenetre;
    private int nbLignes, nbColonnes, nbMines;

	public ConsommateurConfig(PanneauConfig panneau, FenetrePrincipal fenetre, int l, int c, int m) {
        super();
        this.panneau = panneau;
        this.fenetre = fenetre;
        this.nbLignes = l;
        this.nbColonnes = c;
        this.nbMines = m;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == panneau.getBtnPlusLignes()) {
            if (nbLignes < 30) nbLignes++;                      // Pas plus de 30 lignes
        } else if (source == panneau.getBtnMoinsLignes()) {
            if (nbLignes > 4) nbLignes--;                       // Pas moins de 4 lignes
        }
        if (source == panneau.getBtnPlusColonnes()) {
            if (nbColonnes < 30) nbColonnes++;                  // Pas plus de 30 Colonnes
        } else if (source == panneau.getBtnMoinsColonnes()) {
            if (nbColonnes > 4) nbColonnes--;                   // Pas moins de 4 Colonnes
        }
        if (source == panneau.getBtnPlusMines()) {
            if (nbMines < (nbColonnes*nbLignes-1)) nbMines++;   // Sécurité pour pas avoir toute la grille de mines
        } else if (source == panneau.getBtnMoinsMines()) {
            if (nbMines > 1) nbMines--;                         // Au minimum une mines
        }
        if (source == panneau.getbtnValider()) {
            this.fenetre.afficherJeu(this.nbLignes, this.nbColonnes, this.nbMines);
        }

        panneau.mettreAJourTexte(nbLignes, nbColonnes, nbMines);
    }
}