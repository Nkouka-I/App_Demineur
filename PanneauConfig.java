import javax.swing.*;
import java.awt.*;

public class PanneauConfig extends JPanel{
	private FenetrePrincipal fenetre;

	private JButton btnPlusLignes = new JButton("+");
	private JButton btnMoinsLignes = new JButton("-");
	private JButton btnPlusColonnes = new JButton("+");
	private JButton btnMoinsColonnes = new JButton("-");
	private JButton btnValider = new JButton("Valider");
	protected int l = 4, c = 4;
	private JLabel texteLignes = new JLabel("Lignes : " + l);
	private JLabel texteColonnes = new JLabel("Colonnes : " + c);

	public PanneauConfig(FenetrePrincipal fenetre){
		this.fenetre = fenetre;

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

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
		this.add(btnValider, gbc);

		ConsommateurConfig cc = new ConsommateurConfig(this);
		btnPlusLignes.addActionListener(cc);
		btnMoinsLignes.addActionListener(cc);
		btnPlusColonnes.addActionListener(cc);
		btnMoinsColonnes.addActionListener(cc);
	}

	public JButton getBtnPlusLignes() { return btnPlusLignes; }
	public JButton getBtnMoinsLignes() { return btnMoinsLignes; }
	public JButton getBtnPlusColonnes() { return btnPlusColonnes; }
	public JButton getBtnMoinsColonnes() { return btnMoinsColonnes; }

	public void mettreAJourTexte(int l, int c){
		this.texteLignes.setText("Lignes : " + l);
    	this.texteColonnes.setText("Colonnes : " + c);
	}
	public int getColonnes() { return }

}