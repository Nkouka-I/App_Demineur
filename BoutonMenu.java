import javax.swing.*;
import java.awt.*;

public class BoutonMenu extends JButton{

    public BoutonMenu(String texte, int largeur, int hauteur, boolean estPrincipal) {
        super(texte);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        setFont(new Font("sans-serif", Font.BOLD, 15));
        this.setPreferredSize(new Dimension(largeur, hauteur));

        if (estPrincipal) {
            this.setBackground(Style.VERT_FONCE);
            this.setForeground(Style.VERT_CLAIR);
        } else {
            this.setBackground(Style.VERT_CLAIR);
            this.setForeground(Style.VERT_FONCE);
        }
    }

    @Override
    protected void paintComponent(Graphics pinceau) {
         // obligatoire : on crée un nouveau pinceau pour pouvoir le modifier plus tard
        Graphics2D secondPinceau = (Graphics2D) pinceau.create();

        secondPinceau.setColor(this.getBackground());
        
        secondPinceau.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Dessine en forme de pilule
        super.paintComponent(secondPinceau);

        secondPinceau.dispose();
    }
}