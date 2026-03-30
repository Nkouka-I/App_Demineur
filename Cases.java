import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cases extends JButton{
	protected boolean estminee;
	protected int nbminesV;
	protected boolean visibilite;
	protected int etatMarqueur;
	protected int x;
	protected int y;

	



	public cases(int x,int y){
		this.estminee=false;
		this.nbminesV=0;
		this.visibilite=false;
		this.etatMarqueur=0;
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(40,40));
	}
	public cases getcase(){
		return this;
	}
	public void mettreAjourAffichage(){
		if (visibilite==false){
			setBackground(null);
			if (etatMarqueur==1){
				setText("");   /* mettre un drapeau*/
				setForeground(Color.RED);
			}else if (etatMarqueur==2){
				setText("?");
				setForeground(Color.ORANGE);

			}else{
				setText("");
			}
		}

		if (estminee){
				setText("bombe");
				setBackground(Color.RED);
			}
		setBackground(Color.GREY);
		if (nbminesV==0){
			setText("")
		}else if(nbminesV==1){
			setText("1");
			setForeground(Color.BLUE);
		}else if(nbminesV==2){
			setText("2");
			setForeground(Color.BLUE);
		}else if(nbminesV==3){
			setText("3");
			setForeground(Color.BLUE);
		}else if(nbminesV==4){
			setText("4");
			setForeground(Color.BLUE);
		}else if(nbminesV==5){
			setText("5");
			setForeground(Color.BLUE);  /* A CHANGER LES COULZURS*/
		}else if(nbminesV==6){
			setText("6");
			setForeground(Color.BLUE);
		}else if(nbminesV==7){
			setText("7");
			setForeground(Color.BLUE);
		}else if(nbminesV==8){
			setText("8");
			setForeground(Color.BLUE);
		}



	

	}

}





}
