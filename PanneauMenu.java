import javax.swing.*;
import java.awt.*;

public class PanneauMenu extends JPanel{
	private FenetrePrincipal fenetre;

	private JButton btnNewGame = new JButton("Nouvelle Partie");
	private JButton btnReprendre = new JButton("Reprendre"); 
	private JButton btnQuitter = new JButton("Quitter");
	private	JLabel titre = new JLabel("DÉMINEUR");

	public PanneauMenu(FenetrePrincipal fenetre){
		this.fenetre = fenetre;

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;						   			 //Place les boutons en colonne

		titre.setFont(new Font("Arial", Font.BOLD, 40));
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 50, 20);  		 //Sépare le titre des bouttons
		this.add(titre, gbc);

		gbc.insets = new Insets(0, 0, 20, 0); 			 //Sépare les bouttons entre eux
		Dimension tailleBouton = new Dimension(130, 30); //Dimensionne tout les boutons à une taille unique
	    btnNewGame.setPreferredSize(tailleBouton);
	    btnReprendre.setPreferredSize(tailleBouton);
	    btnQuitter.setPreferredSize(tailleBouton);

	    ConsommateurMenu cm = new ConsommateurMenu(this, this.fenetre);

		gbc.gridy = 1;
        this.add(btnNewGame, gbc);
        btnNewGame.addActionListener(cm);
        
        gbc.gridy = 2;
        this.add(btnReprendre, gbc);
        
        gbc.gridy = 3;
        this.add(btnQuitter, gbc);
		btnQuitter.addActionListener(cm);
	}

	public JButton getBtnReprendre() { return btnReprendre; }
	public JButton getBtnNewGame() { return btnNewGame; }
	public JButton getBtnQuitter() { return btnQuitter; }

}