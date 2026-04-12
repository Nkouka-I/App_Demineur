import javax.swing.*;
import java.awt.*;


public class Cases extends JButton{
	protected boolean estminee;
	protected int nbminesV;
	protected boolean visibilite;
	protected int etatMarqueur;
	protected int x;
	protected int y;
	private static final Color[] couleurs ={Style.CHIFFRE_1,
											Style.CHIFFRE_2, 
											Style.CHIFFRE_3,
											Style.CHIFFRE_4,
											Style.CHIFFRE_5,
											Style.CHIFFRE_6,
											Style.CHIFFRE_7,
											Style.CHIFFRE_8
											};
	/* Constructeur des cases individuelles contenues dans la grille*/
	public Cases(int x,int y){
		this.estminee=false;
		this.nbminesV=0;
		this.visibilite=false;
		this.etatMarqueur=0;
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(75,75));
		setFont(new Font("sans-serif", Font.BOLD, 16));
		setMargin(new Insets(0,0,0,0));
		this.setOpaque(true);
        this.setBorderPainted(false);

		/* Alternance couleurs des cases*/
		if ((x+y)%2 == 0){
			this.setBackground(Style.VERT_FONCE);
		}else{
			this.setBackground(Style.VERT_CACTUS);
		}
	}

	public Cases getcase(){
		return this;
	}

	public void mettreAjourAffichage() { /* permet de changer l'image sur la case qui est en rapport avec l'etat de son marqueur*/
	    if (visibilite == false) {
			if ((x+y)%2 == 0){
				this.setBackground(Style.VERT_FONCE);
			}else{
				this.setBackground(Style.VERT_CACTUS);
			}
	        if (etatMarqueur == 1) {
	            setText("⚑"); /* mettre un drapeau sur la case*/
	            setForeground(Style.ROUGE_DRAPEAU);
	        } else if (etatMarqueur == 2) {
	            setText("?");
	            setForeground(Color.WHITE);
	        } else {
	            setText("");
	        }
	        return;  /* on sort si pas visible */
	    }

	    setEnabled(true);
	    setFocusPainted(false);

	    if (estminee) {
	        setText("💣");
	        setBackground(Style.ROUGE_DRAPEAU);
	        return;  /* on sort si mine */
	    }

		if ((x+y)%2 == 0){
			setBackground(Style.SABLE_BASE);
		}else{
			setBackground(Style.SABLE_REVELE);
		}

		if (nbminesV==0){
			setText("");
		}else{
			setText(String.valueOf(nbminesV));		
			setForeground(couleurs[nbminesV-1]);
		}
		repaint();
	}
}





