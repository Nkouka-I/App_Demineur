import javax.swing.*;
import java.awt.*;

public class PanneauJeu extends JPanel{
    private FenetrePrincipal fenetre;
    private Grille grille;
    private JLabel labelMines, labelCoups;
    private int nbCoups = 0, mines;

    public PanneauJeu(FenetrePrincipal fenetre, int lignes, int colonnes, int mines){
        this.fenetre = fenetre;
        this.setLayout(new BorderLayout());
        this.setBackground(Style.SABLE_BASE);
        this.mines=mines;

        creerHUD();//Creer le panneau Coups joués et Mines restantes

        this.grille = new Grille(lignes, colonnes, mines,this);
        this.add(grille.afficherGrille(), BorderLayout.CENTER);

    }  
    private void creerHUD(){
        JPanel hud = new JPanel(new FlowLayout());

        labelMines = new JLabel("Mines restantes : " + mines);
        labelCoups = new JLabel("Coups joués : 0");
        labelMines.setFont(new Font("Arial", Font.BOLD, 14));
        labelCoups.setFont(new Font("Arial", Font.BOLD, 14));
        hud.add(labelMines);
        hud.add(labelCoups);
        this.add(hud, BorderLayout.NORTH);
    }
        

    public void incrementerCoups() {
        nbCoups++;
        labelCoups.setText("Coups joués : " + nbCoups);
    }

    public void mettreAjourMines(int delta) {
        mines += delta; 
        labelMines.setText("Mines restantes : " + mines);
    }
    public FenetrePrincipal getFenetrePrincipal(){
        return this.fenetre;
    }
}