import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.Random;

public class Grille {
	private int lignes;
	private int colonnes;
	private Cases[][] cases;

	public Grille(int lignes,int colonnes,int nbmines){
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.cases=new Cases[lignes][colonnes];
		initCases();
		initMines(nbmines);
		calculMinesV();

	}
	public void initCases(){
		for (int i=0;i<lignes;i++){
			for (int y=0;y<colonnes;y++){
				cases[i][y]= new Cases(i,y);
				cases[i][y].addMouseListener(new GestionSouris(cases[i][y],this));
			}
		}

	}
	public void initMines(int nbmines){
		Random rand=new Random();
		int poser=0;
		while (poser<nbmines){
			int i = rand.nextInt(lignes);
			int y = rand.nextInt(colonnes);
			if (cases[i][y].estminee==false){
				cases[i][y].estminee=true;
				poser++;
			}
		}

	}

	public void calculMinesV(){
		for (int i=0;i<lignes;i++){
			for (int y=0;y<colonnes;y++){
				int cpt=0;

				for (int u=-1;u<=1;u++){
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

	public void reveleBombes(){
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
				if (cases[i][y].estminee==false && cases[i][y].visibilite==false){
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

	// méthode récursive qui propage la révélation
public void propager(int x, int y) {

    // on sort si hors de la grille
    if (x < 0 || x >= lignes || y < 0 || y >= colonnes) return;

    // on sort si déjà révélée ou minée
    if (cases[x][y].visibilite || cases[x][y].estminee) return;

    // on révèle la case
    cases[x][y].visibilite = true;
    cases[x][y].mettreAjourAffichage();

    // si elle a des mines voisines on s'arrête ici
    if (cases[x][y].nbminesV > 0) return;

    // si 0 mines voisines → on propage aux 8 voisins
    for (int u = -1; u <= 1; u++) {
        for (int v = -1; v <= 1; v++) {
            if (u != 0 || v != 0) {  // on évite la case elle-même
                propager(x + u, y + v);
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


