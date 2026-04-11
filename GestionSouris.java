import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class GestionSouris extends MouseAdapter {
    private Cases caseEcoutee;
    private Grille grille;

    public GestionSouris(Cases caseEcoutee, Grille grille) {
        this.caseEcoutee = caseEcoutee;
        this.grille = grille;
    }

    @Override /* Listener permettant d'écouter la souris afin de réaliser les actions*/
    public void mouseReleased(MouseEvent evenement) {
        if (evenement.getButton() == MouseEvent.BUTTON1) {
            if (!caseEcoutee.visibilite && caseEcoutee.etatMarqueur == 0) {

                grille.propager(caseEcoutee.x, caseEcoutee.y);
                grille.getFenetre().incrementerCoups();

                if (caseEcoutee.estminee) {
                    grille.reveleBombes();
                    SauvegardePartie.supprimer();
                    JOptionPane.showMessageDialog(null, "Perdu !");
                    grille.getFenetre().getFenetrePrincipal().afficherMenu();
                    return;
                }
                if (grille.verifVictoire()) {
                    SauvegardePartie.supprimer();
                    JOptionPane.showMessageDialog(null, "Gagné !");
                    grille.getFenetre().getFenetrePrincipal().afficherMenu();
                }
            }
        }
        else if (evenement.getButton() == MouseEvent.BUTTON3) {
            if (!caseEcoutee.visibilite) {
            int etatPrecedent = caseEcoutee.etatMarqueur;
            PanneauJeu panneau = grille.getFenetre();

            if (etatPrecedent == 0) {
                if (panneau.peutPoserDrapeau()) { // On demande l'autorisation au panneau
                    caseEcoutee.etatMarqueur = 1;
                    panneau.mettreAjourMines(-1);
                }else {
                return; 
            }
        }   else if (etatPrecedent == 1) {
                caseEcoutee.etatMarqueur = 2;
                panneau.mettreAjourMines(1);
        }   else { 
                caseEcoutee.etatMarqueur = 0;
        }
        caseEcoutee.mettreAjourAffichage();
    }
}
}
}