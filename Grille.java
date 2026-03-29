import java.util.random;

public class Grille {
	private int lignes;
	private int colonnes;
	private Cases[][] cases;

	public Grille(int lignes,int colonnes){
		this.lignes=lignes;
		this.colonnes=colonnes;
		this.cases=new Cases([lignes][colonnes]);
		initCases();

	}
	public void initCases(){
		for (int i=0;i<lignes;i++){
			for (int y=0;y<colonnes;y++){
				cases[i][y]= new Cases(i,y);
				cases[i][y].addMouseAdapter(new GestionSouris(cases[i][y],this));
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


