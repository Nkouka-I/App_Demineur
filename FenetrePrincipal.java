import javax.swing.*;
import java.awt.*;

public class FenetrePrincipal extends JFrame{

	public FenetrePrincipal() {
        this.setTitle("Démineur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //Centre la fenêtre sur l'écran
        
        this.afficherMenu(); 
    }

    public void afficherMenu() {
        this.getContentPane().removeAll(); //Tableau Blanc
        this.add(new PanneauMenu(this));   //Ajout Menu
        this.revalidate();                 //Redimention LayoutManager
        this.repaint();                    //Rafraîchissement
        this.pack();					   //Redimentionne la fenetre
        this.setVisible(true);
    }

    public void afficherConfig() {
        this.getContentPane().removeAll(); //Tableau Blanc
        this.add(new PanneauConfig(this));   //Ajout Menu
        this.revalidate();                 //Redimention LayoutManager
        this.repaint();                    //Rafraîchissement
        this.pack();
    }

    public void afficherJeu(int lignes, int colonnes) {
        this.getContentPane().removeAll();
        this.add(new PanneauJeu(this, lignes, colonnes));
        this.revalidate();
        this.repaint();
        this.pack();
    }
}