import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cases extends JButton{
	protected boolean estminee;
	protected int nbminesV;
	protected boolean visibilite;
	protected int etatMarqueur;
	protected int x;
	protected int y;

	public cases(int nbminesV,int etatMarqueur,int x,int y){
		this.nbminesV=nbminesV;
		this.visibilite=false;
		this.etatMarqueur=etatMarqueur;
		this.x=x;
		this.y=y;
	}
	public cases getcase(){
		return this;
	}

}
