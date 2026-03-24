


public class GestionSouris implements MouseListener{
	private Cases case_en_cours;


	public GestionSouris(Cases case_en_cours){
		this.case_en_cours=case_en_cours;
	}
	@Override
	public void mouseClicked(MouseEvent e){
		if (e.getButton()==MouseEvent.BUTTON1){
			case_en_cours.reveler();       /* cette ligne permet de reveler la case il faut coder la fonction dans case.*/
		}
		else if(e.getButton()==MouseEvent.BUTTON3){
			case_en_cours./*a voir*/
		}
	}

	/* a continuer toutes les méthodes pour les graphismes*/
}

