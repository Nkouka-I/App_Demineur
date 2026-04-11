import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsommateurMenu implements ActionListener {
    private PanneauMenu panneau;
    private FenetrePrincipal fenetre;

    public ConsommateurMenu(PanneauMenu panneau, FenetrePrincipal fenetre) {
        super();
        this.panneau = panneau;
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == panneau.getBtnNewGame()) {
            this.fenetre.afficherConfig();
        } else if (source == panneau.getBtnReprendre()) {
            this.fenetre.afficherJeuSauvegarde();
        } else if (source == panneau.getBtnQuitter()) {
            System.exit(0);
        }
    }
}