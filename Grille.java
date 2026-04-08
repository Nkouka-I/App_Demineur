import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.Random;

public class Grille extends JPanel {
	private int lignes,colonnes;
	private Cases[][] cases;
	private PanneauJeu fenetre;

	public Grille(int lignes,int colonnes,int nbmines,PanneauJeu fenetre){
		this.fenetre=fenetre;
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.cases=new Cases[lignes][colonnes];
		initCases(); /* permet de creer les cases de la grille a l'aide de Cases.java */
		initMines(nbmines); /* positionnement des mines au hazard avec le nombre de mines saisie dans le menu.*/
		calculMinesV(); /* Calcul des mines voisines de la case decouverte */

	}
	public PanneauJeu getFenetre(){
		return fenetre;
	}
	public void initCases(){
		for (int i=0;i<lignes;i++){
			for (int y=0;y<colonnes;y++){
				cases[i][y]= new Cases(i,y);   /* Création des cases*/

				// Alternance : si (i+j) est pair -> Vert Foncé, sinon -> Vert clair
				if ((i+y)%2 == 0){
					cases[i][y].setBackground(Style.VERT_FONCE);
				}else{
					cases[i][y].setBackground(Style.VERT_CACTUS);
				}
				cases[i][y].addMouseListener(new GestionSouris(cases[i][y],this)); /* Puis les mettres sur ecoutes grace la class GestionSouris.java */  
			}
		}

	}
	public void initMines(int nbmines){
		Random rand=new Random();
		int poser=0;
		while (poser<nbmines){
			int i = rand.nextInt(lignes); /* Choix de ligne au hazard*/
			int y = rand.nextInt(colonnes); /* Puis choix de la colonne au hazard*/
			if (cases[i][y].estminee==false){
				cases[i][y].estminee=true;
				poser++;
			}
		}

	}

	public void calculMinesV(){
		for (int i=0;i<lignes;i++){       /* Parcour des Cases*/
			for (int y=0;y<colonnes;y++){
				int cpt=0;
				for (int u=-1;u<=1;u++){     /* Parcours des cases voisines celles parcourue sont celles qui sont autour de celle au centre */
					for (int v=-1;v<=1;v++){
						int voisinI=i+u;
						int voisinY=y+v;
						if ((voisinI>=0 && voisinI<lignes) && (voisinY>=0 && voisinY<colonnes)){
							if (cases[voisinI][voisinY].estminee){
								cpt++;
							}
						}
					}				
				}cases[i][y].nbminesV=cpt;
			}
		}

	}

	public void reveleBombes(){     /*revele les bombes en cas de perte */
		for (int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				if (cases[i][j].estminee){
					cases[i][j].visibilite=true;
					cases[i][j].mettreAjourAffichage();  
				}
			}
		}
	}

	public boolean verifVictoire(){
		for (int i=0;i<lignes;i++){   
			for (int y=0;y<colonnes;y++){
				if (cases[i][y].estminee==false && cases[i][y].visibilite==false){ /*Parcour lignes colonnes pour trouver une case qui doit etre miner*/
					return false;
				}
			}
		}return true;

	}

	public JPanel afficherGrille() {
    	JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(lignes, colonnes));
    	for (int i = 0; i < lignes; i++) {
        	for (int j = 0; j < colonnes; j++) {
            	panel.add(cases[i][j]);
	        }
	    }
    	return panel;
	}

	
	public void propager(int x, int y) {
    	if (x < 0 || x >= lignes || y < 0 || y >= colonnes) return; /* si hors de la grille on sort*/
    	if (cases[x][y].visibilite || cases[x][y].estminee) return; /* si case miner ou visible on sort*/
    	cases[x][y].visibilite = true;
    	cases[x][y].mettreAjourAffichage(); /* révélée la case */
    	if (cases[x][y].nbminesV > 0) return;
    	for (int u = -1; u <= 1; u++) {
        	for (int v = -1; v <= 1; v++) {
            	if (u != 0 || v != 0) {  
                	propager(x + u, y + v); /* appel recursif pour les cases voisines */
            	}
        	}
    	}
	}

	public void reveleCase(int x, int y) {
    	cases[x][y].visibilite = true;
    	cases[x][y].mettreAjourAffichage();   
	}	

	public int getLignes(){
		return lignes;

	}
	public int getcolonnes(){
		return colonnes;
	}
}


