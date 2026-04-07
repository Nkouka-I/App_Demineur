import javax.swing.*;
import java.awt.*;

public class PanneauJeu extends JPanel{
    private FenetrePrincipal fenetre;
    private Grille grille;
    private JLabel labelMines;
    private JLabel labelCoups;
    private int nbCoups = 0;
    private int mines;

    public PanneauJeu(FenetrePrincipal fenetre, int lignes, int colonnes, int mines){
        this.fenetre = fenetre;
        this.setLayout(new BorderLayout());
        this.mines=mines;

        JPanel panneauHaut = new JPanel(new FlowLayout());
        labelMines = new JLabel("Mines restantes : " + mines);
        labelCoups = new JLabel("Coups joués : 0");
        labelMines.setFont(new Font("Arial", Font.BOLD, 14));
        labelCoups.setFont(new Font("Arial", Font.BOLD, 14));
        panneauHaut.add(labelMines);
        panneauHaut.add(labelCoups);
        add(panneauHaut, BorderLayout.NORTH);

        grille = new Grille(lignes, colonnes, mines);
        add(grille.afficherGrille(), BorderLayout.CENTER);

    }  
        

    public void incrementerCoups() {
        nbCoups++;
        labelCoups.setText("Coups joués : " + nbCoups);
    }

    public void mettreAjourMines(int delta) {
        mines += delta; 
        labelMines.setText("Mines restantes : " + mines);
    }
}