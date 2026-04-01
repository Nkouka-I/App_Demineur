import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class testjeu extends JFrame {

    private Grille grille;

    public testjeu() {
        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);  // ← taille fixe

        grille = new Grille(9, 9, 10);

        add(grille.afficherGrille(), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new testjeu();
    }
}