import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class Cases extends JButton{
	protected boolean estminee;
	protected int nbminesV;
	protected boolean visibilite;
	protected int etatMarqueur;
	protected int x;
	protected int y;
	private static final Color[] couleurs ={Color.BLUE,new Color(0,128,0),Color.RED,new Color(0,0,128),new Color(128,0,0),new Color(0,128,128),Color.BLACK,new Color(128,128,128)};

	



	public Cases(int x,int y){
		this.estminee=false;
		this.nbminesV=0;
		this.visibilite=false;
		this.etatMarqueur=0;
		this.x=x;
		this.y=y;
		setPreferredSize(new Dimension(40,40));
		setFont(new Font("Arial",Font.BOLD,16));
		setMargin(new Insets(0,0,0,0));
		  
   
	}
	public Cases getcase(){
		return this;
	}
public void mettreAjourAffichage() {
    if (visibilite == false) {
        setBackground(null);
        if (etatMarqueur == 1) {
            setText("⚑");
            setForeground(Color.RED);
        } else if (etatMarqueur == 2) {
            setText("?");
            setForeground(Color.ORANGE);
        } else {
            setText("");
        }
        return;  // ← on sort si pas visible
    }

     
    setEnabled(true);
    setFocusPainted(false);
    setBorderPainted(false);

    if (estminee) {
        setText("💣");
        setBackground(Color.RED);
        return;  // ← on sort si mine
    }
		setBackground(new Color(128,128,128));
		if (nbminesV==0){
			setText("");
		}else{
			setText(String.valueOf(nbminesV));		
			setForeground(couleurs[nbminesV-1]);
		}


	

	}

}





