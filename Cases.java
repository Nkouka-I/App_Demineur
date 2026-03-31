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

	



	public Cases(int x,int y){
		this.estminee=false;
		this.nbminesV=0;
		this.visibilite=false;
		this.etatMarqueur=0;
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(40,40));
	}
	public Cases getcase(){
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
		setBackground(new Color(128,128,128));
		if (nbminesV==0){
			setText("");
		}else if(nbminesV==1){
			setText("1");
			setForeground(Color.BLUE);
		}else if(nbminesV==2){
			setText("2");
			setForeground(new Color(0,128,0));
		}else if(nbminesV==3){
			setText("3");
			setForeground(Color.RED);
		}else if(nbminesV==4){
			setText("4");
			setForeground(new Color(0,0,128));
		}else if(nbminesV==5){
			setText("5");
			setForeground(new Color(128,0,0));
		}else if(nbminesV==6){
			setText("6");
			setForeground(new Color(0,128,128));
		}else if(nbminesV==7){
			setText("7");
			setForeground(Color.BLACK);
		}else if(nbminesV==8){
			setText("8");
			setForeground(new Color(128,128,128));
		}



	

	}

}





