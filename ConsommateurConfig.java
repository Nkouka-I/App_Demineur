import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsommateurConfig implements ActionListener{
	private PanneauConfig panneau;
    private FenetrePrincipal fenetre;
    private int nbLignes = 4, nbColonnes = 4;

	public ConsommateurConfig(PanneauConfig panneau, FenetrePrincipal fenetre) {
        super();
        this.panneau = panneau;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == panneau.getBtnPlusLignes()) {
            if (nbLignes < 30) nbLignes++;                  // Sécurité pour pas avoir plus de 30 lignes
        } else if (source == panneau.getBtnMoinsLignes()) {
            if (nbLignes > 4) nbLignes--;                   // Sécurité pour pas avoir moins de 4 lignes
        }
        if (source == panneau.getBtnPlusColonnes()) {
            if (nbColonnes < 30) nbColonnes++;                  // Sécurité pour pas avoir plus de 30 lignes
        } else if (source == panneau.getBtnMoinsColonnes()) {
            if (nbColonnes > 4) nbColonnes--;                   // Sécurité pour pas avoir moins de 4 lignes
        }
        if (source == panneau.getbtnValider()) {
            this.fenetre.afficherJeu(this.nbLignes, this.nbColonnes);
        }

        panneau.mettreAJourTexte(nbLignes, nbColonnes);
    }
}