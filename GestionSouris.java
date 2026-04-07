import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;


public class GestionSouris extends MouseAdapter {
	private Cases caseEcoutee;
	private Grille grille;

	public GestionSouris(Cases caseEcoutee , Grille grille){
		this.caseEcoutee=caseEcoutee;
        this.grille=grille;
	}

@Override
public void mouseReleased(MouseEvent evenement) {
    if (evenement.getButton() == MouseEvent.BUTTON1) {
        if (!caseEcoutee.visibilite && caseEcoutee.etatMarqueur == 0) {

            grille.propager(caseEcoutee.x, caseEcoutee.y);
            grille.getFenetre().incrementerCoups();

            if (caseEcoutee.estminee) {
                grille.reveleBombes();
                JOptionPane.showMessageDialog(null, "Perdu !");
                grille.getFenetre().getFenetrePrincipal().afficherMenu();
            }
            if (grille.verifVictoire()) {
                JOptionPane.showMessageDialog(null, "Gagné !");
                grille.getFenetre().getFenetrePrincipal().afficherMenu();
            }
        }
    } else if (evenement.getButton() == MouseEvent.BUTTON3) {
        if (!caseEcoutee.visibilite) {
            caseEcoutee.etatMarqueur = (caseEcoutee.etatMarqueur + 1) % 3;
            caseEcoutee.mettreAjourAffichage();

            if (caseEcoutee.etatMarqueur == 1) {
                grille.getFenetre().mettreAjourMines(-1);
            } else if (caseEcoutee.etatMarqueur == 0) {
                grille.getFenetre().mettreAjourMines(+1);
            }
        }
    }
}
}
