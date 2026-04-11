import javax.swing.*;
import java.awt.*;

public class PanneauJeu extends JPanel {
    private FenetrePrincipal fenetre;
    private Grille grille;
    private JLabel labelMines, labelCoups;
    private int nbCoups = 0, mines;

    /* Création d'un nouveau panneau de jeu*/
    public PanneauJeu(FenetrePrincipal fenetre, int lignes, int colonnes, int mines) {
        this.fenetre = fenetre;
        this.mines   = mines;
        this.setLayout(new BorderLayout());
        this.setBackground(Style.SABLE_BASE);
        creerHUD();
        this.grille = new Grille(lignes, colonnes, mines, this);
        this.add(grille.afficherGrille(), BorderLayout.CENTER);
    }
    /* Création du panneau de jeu a partir des données du fichier de sauvegarde */
    public PanneauJeu(FenetrePrincipal fenetre, SauvegardePartie sauvegarde) {
        this.fenetre = fenetre;
        this.mines   = sauvegarde.getMinesRestantes();
        this.nbCoups = sauvegarde.getNbCoups();
        this.setLayout(new BorderLayout());
        this.setBackground(Style.SABLE_BASE);
        creerHUD();
        labelCoups.setText("Coups joués : " + nbCoups);
        labelMines.setText("Mines restantes : " + mines);
        this.grille = new Grille(sauvegarde, this);
        this.add(grille.afficherGrille(), BorderLayout.CENTER);
    }

    private void creerHUD() {
        JPanel hud = new JPanel(new FlowLayout());
        labelMines = new JLabel("Mines restantes : " + mines);
        labelCoups = new JLabel("Coups joués : 0");
        labelMines.setFont(new Font("Arial", Font.BOLD, 14));
        labelCoups.setFont(new Font("Arial", Font.BOLD, 14));
        JButton btnSauvegarder = new JButton("Sauvegarder");
        btnSauvegarder.addActionListener(e -> sauvegarderPartie());
        hud.add(labelMines);
        hud.add(labelCoups);
        hud.add(btnSauvegarder);
        this.add(hud, BorderLayout.NORTH);
    }
    /* méthode montrant les deux cas possibles apres l'intéraction du bouton de sauvegarde*/
    public void sauvegarderPartie() {
        SauvegardePartie sauvegarde = new SauvegardePartie(grille, nbCoups, mines);
        if (sauvegarde.sauvegarder()) {
            JOptionPane.showMessageDialog(this, "Partie sauvegardée !", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erreur lors de la sauvegarde.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    /* méthode pour verifier le nombre maximal de drapeau que l'on peut poser sur la grille */
    public boolean peutPoserDrapeau() {
        return this.mines > 0;
    }

    public void incrementerCoups() {
        nbCoups++;
        labelCoups.setText("Coups joués : " + nbCoups);
    }

    public void mettreAjourMines(int delta) {
        mines += delta;
        labelMines.setText("Mines restantes : " + mines);
    }

    public FenetrePrincipal getFenetrePrincipal() { return this.fenetre; }
}
