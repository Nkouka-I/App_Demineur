import javax.swing.*;
import java.awt.*;

public class PanneauMenu extends JPanel {
    private FenetrePrincipal fenetre;
    private BoutonMenu btnNewGame;
    private BoutonMenu btnReprendre;
    private BoutonMenu btnQuitter;
    private JLabel titre;

    public PanneauMenu(FenetrePrincipal fenetre) {
        this.fenetre = fenetre;
        this.setBackground(Style.SABLE_FOND);

        this.titre = new JLabel("DÉMINEUR");
        this.titre.setFont(new Font("Segoe UI", Font.BOLD, 40));
        this.titre.setForeground(Style.VERT_FONCE);

        ImageIcon logo = new ImageIcon("logo_bombe.png");
        Image img = logo.getImage();
        Image imgRedimensionnee = img.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
        JLabel labelLogo = new JLabel(new ImageIcon(imgRedimensionnee));

        int btnl = 180, bnth = 30;
        btnNewGame   = new BoutonMenu("Nouvelle Partie", btnl, bnth, true);
        btnReprendre = new BoutonMenu("Reprendre", btnl, bnth, false);
        btnQuitter   = new BoutonMenu("Quitter", btnl, bnth, true);

        btnReprendre.setEnabled(SauvegardePartie.existeSauvegarde());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        this.add(labelLogo, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 20, 30, 20);
        this.add(titre, gbc);

        gbc.insets = new Insets(0, 0, 20, 0);

        ConsommateurMenu cm = new ConsommateurMenu(this, this.fenetre);

        gbc.gridy = 2;
        this.add(btnNewGame, gbc);
        btnNewGame.addActionListener(cm);

        gbc.gridy = 3;
        this.add(btnReprendre, gbc);
        btnReprendre.addActionListener(cm); 
        gbc.gridy = 4;
        this.add(btnQuitter, gbc);
        btnQuitter.addActionListener(cm);
    }

    public JButton getBtnReprendre(){
        return btnReprendre;
    }
    public JButton getBtnNewGame(){
        return btnNewGame;
    }
    public JButton getBtnQuitter(){
        return btnQuitter;
    }
}