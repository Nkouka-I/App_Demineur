import javax.swing.JFrame;

public class MainTest{	
	public static void main(String[] args) {
		FenetrePrincipal fenetre = new FenetrePrincipal();

		PanneauConfig config = new PanneauConfig(fenetre);

		fenetre.getContentPane().removeAll();
	    fenetre.add(config);
	        
		fenetre.revalidate();
		fenetre.repaint();
		fenetre.pack(); 
		fenetre.setLocationRelativeTo(null); // Centrage sur l'écran
		fenetre.setVisible(true);
	}
}