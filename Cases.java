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

}
