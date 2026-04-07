import javax.swing.*;
import java.awt.*;

public class PanneauMenu extends JPanel{
	private FenetrePrincipal fenetre;
	private BoutonMenu btnNewGame;
	private BoutonMenu btnReprendre; 
	private BoutonMenu btnQuitter;
	private	JLabel titre;

	public PanneauMenu(FenetrePrincipal fenetre){
		this.fenetre = fenetre;
		this.setBackground(Style.SABLE_BASE);

		//Init Titre
		this.titre = new JLabel("DÉMINEUR");
		this.titre.setFont(new Font("Segoe UI", Font.BOLD, 40));
		this.titre.setForeground(Style.VERT_FONCE);
		
		//Init logo
		ImageIcon logo = new ImageIcon("logo_bombe.png");
        Image img = logo.getImage(); 
        Image imgRedimensionnee = img.getScaledInstance(150, -1, Image.SCALE_SMOOTH);

		//Init Logo
		JLabel labelLogo = new JLabel(new ImageIcon(imgRedimensionnee));

		//Init Boutons
		int btnl = 180, bnth = 30;
		btnNewGame = new BoutonMenu("Nouvelle Partie", btnl, bnth, true);
		btnReprendre = new BoutonMenu("Reprendre", btnl, bnth, false); 
		btnQuitter = new BoutonMenu("Quitter", btnl, bnth, true);

		//Organisation Page
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;						   			 	//Place les boutons en colonne
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		this.add(labelLogo, gbc);

		gbc.gridy = 1;
		gbc.insets = new Insets(0, 20, 30, 20);  		 	//Sépare le titre des bouttons
		this.add(titre, gbc);

		gbc.insets = new Insets(0, 0, 20, 0); 			 	//Sépare les bouttons entre eux

	    ConsommateurMenu cm = new ConsommateurMenu(this, this.fenetre);
		gbc.gridy = 2;
        this.add(btnNewGame, gbc);
        btnNewGame.addActionListener(cm);
        
        gbc.gridy = 3;
        this.add(btnReprendre, gbc);
        
        gbc.gridy = 4;
        this.add(btnQuitter, gbc);
		btnQuitter.addActionListener(cm);
	}

	public JButton getBtnReprendre() { return btnReprendre; }
	public JButton getBtnNewGame() { return btnNewGame; }
	public JButton getBtnQuitter() { return btnQuitter; }

}