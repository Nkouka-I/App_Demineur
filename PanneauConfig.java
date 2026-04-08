import javax.swing.*;
import java.awt.*;

public class PanneauConfig extends JPanel{
	private FenetrePrincipal fenetre;

	private BoutonMenu btnPlusLignes;
	private BoutonMenu btnMoinsLignes;
	private BoutonMenu btnPlusColonnes;
	private BoutonMenu btnMoinsColonnes;
	private BoutonMenu btnPlusMines;
	private BoutonMenu btnMoinsMines;
	private BoutonMenu btnValider;
	protected int l = 4, c = 4, m = 2;
	private JLabel texteLignes;
	private JLabel texteColonnes;
	private JLabel texteMines;

	public PanneauConfig(FenetrePrincipal fenetre){
		this.fenetre = fenetre;
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Style.SABLE_FOND);

		//Init Boutons
		int btnl = 50, btnh = 50;
		btnPlusLignes = new BoutonMenu("+", btnl, btnh, true);
		btnMoinsLignes = new BoutonMenu("-", btnl, btnh, true);
		btnPlusColonnes = new BoutonMenu("+", btnl, btnh, false);
		btnMoinsColonnes = new BoutonMenu("-", btnl, btnh, false);
		btnPlusMines = new BoutonMenu("+", btnl, btnh, true);
		btnMoinsMines = new BoutonMenu("-", btnl, btnh, true);
		btnValider = new BoutonMenu("Valider", 100, btnh, false);

		//Init Texte
		texteLignes = new JLabel("Lignes : " + l);
		texteColonnes = new JLabel("Colonnes : " + c);
		texteMines = new JLabel("Mines : " + m);

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridy = 0;
		gbc.gridx = 0;						   			 
		this.add(btnMoinsLignes, gbc);

		gbc.gridx = 1;
		this.add(texteLignes, gbc);

		gbc.gridx = 2;
		this.add(btnPlusLignes, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;						   			 
		this.add(btnMoinsColonnes, gbc);

		gbc.gridx = 1;
		this.add(texteColonnes, gbc);

		gbc.gridx = 2;
		this.add(btnPlusColonnes, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;						   			 
		this.add(btnMoinsMines, gbc);

		gbc.gridx = 1;
		this.add(texteMines, gbc);

		gbc.gridx = 2;
		this.add(btnPlusMines, gbc);

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		this.add(btnValider, gbc);

		ConsommateurConfig cc = new ConsommateurConfig(this, this.fenetre, l, c, m);
		btnPlusLignes.addActionListener(cc);
		btnMoinsLignes.addActionListener(cc);
		btnPlusColonnes.addActionListener(cc);
		btnMoinsColonnes.addActionListener(cc);
		btnPlusMines.addActionListener(cc);
		btnMoinsMines.addActionListener(cc);
		btnValider.addActionListener(cc);

	}

	public JButton getBtnPlusLignes() { return btnPlusLignes; }
	public JButton getBtnMoinsLignes() { return btnMoinsLignes; }
	public JButton getBtnPlusColonnes() { return btnPlusColonnes; }
	public JButton getBtnMoinsColonnes() { return btnMoinsColonnes; }
	public JButton getBtnPlusMines() { return btnPlusMines; }
	public JButton getBtnMoinsMines() { return btnMoinsMines; }
	public JButton getbtnValider() { return btnValider; }

	public void mettreAJourTexte(int l, int c, int m){
		this.texteLignes.setText("Lignes : " + l);
    	this.texteColonnes.setText("Colonnes : " + c);
    	this.texteMines.setText("Mines : " + m);
	}

}