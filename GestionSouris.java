public class GestionSouris extends MouseAdapter {
	Cases caseEcoutee

	public GestionSouris(Cases caseEcoutee , Grille grille){
		this.caseEcoutee=caseEcoutee;
	}

    @Override
    public void mouseClicked(MouseEvent evenement) {
        if (evenement.getButton() == MouseEvent.BUTTON1) {
            grille.reveleCase(caseEcoutee.x, caseEcoutee.y);

        } else if (evenement.getButton() == MouseEvent.BUTTON3) {
            if (!caseEcoutee.visibilite) {
                caseEcoutee.etatMarqueur = (caseEcoutee.etatMarqueur + 1) % 3;
            }
        }
    }
}
