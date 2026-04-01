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

            grille.propager(caseEcoutee.x, caseEcoutee.y);  // ← propagation

            if (caseEcoutee.estminee) {
                grille.reveleBombes();
                JOptionPane.showMessageDialog(null, "Perdu !");
            }
            if (grille.verifVictoire()) {
                JOptionPane.showMessageDialog(null, "Gagné !");
            }
        }
    } else if (evenement.getButton() == MouseEvent.BUTTON3) {
        if (!caseEcoutee.visibilite) {
            caseEcoutee.etatMarqueur = (caseEcoutee.etatMarqueur + 1) % 3;
            caseEcoutee.mettreAjourAffichage();
        }
    }
}
}
