import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.Random;

public class Grille {
	private int lignes;
	private int colonnes;
	private Cases[][] cases;

	public Grille(int lignes,int colonnes){
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.cases=new Cases[lignes][colonnes];
		initCases();
	/*	initMines(nbmines); */
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
			for (int y=0;y<colonnes;i++){
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
					}cases[i][y].nbminesV=cpt;
				}
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




	public void reveleCase(int x,int y){
		cases[x][y].visibilite=true;
	}
	public int getLignes(){
		return lignes;

	}
	public int getcolonnes(){
		return colonnes;
	}


	}


