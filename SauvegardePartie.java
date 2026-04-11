
import java.io.*;

public class SauvegardePartie {
    private static final String FICHIER_SAUVEGARDE = "sauvegarde.txt";
    private int lignes, colonnes, nbCoups, minesRestantes;
    private boolean[][] estMinee, visibilite;
    private int[][] etatMarqueur, nbMinesVoisines;

    /* construction a partir de la partie en cours */
    public SauvegardePartie(Grille grille, int nbCoups, int minesRestantes) {
        this.lignes = grille.getLignes();
        this.colonnes = grille.getcolonnes();
        this.nbCoups = nbCoups;
        this.minesRestantes = minesRestantes;
        
        estMinee = new boolean[lignes][colonnes];
        visibilite = new boolean[lignes][colonnes];
        etatMarqueur = new int[lignes][colonnes];
        nbMinesVoisines = new int[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                Cases c = grille.getCase(i, j);
                estMinee[i][j] = c.estminee;
                visibilite[i][j] = c.visibilite;
                etatMarqueur[i][j] = c.etatMarqueur;
                nbMinesVoisines[i][j] = c.nbminesV;
            }
        }
    }

    private SauvegardePartie() {}

    /* flux d'octets pour l'écriture */
    public boolean sauvegarder() {
        try {
            FileOutputStream fos = new FileOutputStream(FICHIER_SAUVEGARDE);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            
            dos.writeInt(lignes);
            dos.writeInt(colonnes);
            dos.writeInt(nbCoups);
            dos.writeInt(minesRestantes);

            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    dos.writeBoolean(estMinee[i][j]);
                    dos.writeBoolean(visibilite[i][j]);
                    dos.writeInt(etatMarqueur[i][j]);
                    dos.writeInt(nbMinesVoisines[i][j]);
                }
            }
            
            dos.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde : " + e.getMessage());
            return false;
        }
    }

    /* chargement des flux d'octets pour la lecture */
    public static SauvegardePartie charger() {
        File fichier = new File(FICHIER_SAUVEGARDE);
        if (!fichier.exists()) return null;

        try {
            // Utilisation d'un Buffer pour accélérer la lecture
            FileInputStream fis = new FileInputStream(fichier);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            
            SauvegardePartie s = new SauvegardePartie();
            
            s.lignes = dis.readInt();
            s.colonnes = dis.readInt();
            s.nbCoups = dis.readInt();
            s.minesRestantes = dis.readInt();

            s.estMinee = new boolean[s.lignes][s.colonnes];
            s.visibilite = new boolean[s.lignes][s.colonnes];
            s.etatMarqueur = new int[s.lignes][s.colonnes];
            s.nbMinesVoisines = new int[s.lignes][s.colonnes];

            for (int i = 0; i < s.lignes; i++) {
                for (int j = 0; j < s.colonnes; j++) {
                    s.estMinee[i][j] = dis.readBoolean();
                    s.visibilite[i][j] = dis.readBoolean();
                    s.etatMarqueur[i][j] = dis.readInt();
                    s.nbMinesVoisines[i][j] = dis.readInt();
                }
            }
            
            dis.close(); // Ferme aussi bis et fis
            return s;
        } catch (IOException e) {
            System.err.println("Erreur chargement : " + e.getMessage());
            return null;
        }
    }

    public static void supprimer() {
        File f = new File(FICHIER_SAUVEGARDE);
        if (f.exists()) f.delete();
    }

    public static boolean existeSauvegarde() {
        return new File(FICHIER_SAUVEGARDE).exists();
    }


    public int getLignes(){
        return lignes;
    }
    public int getColonnes(){
        return colonnes;}
    public int getNbCoups(){
        return nbCoups;
    }
    public int getMinesRestantes(){
     return minesRestantes;
    }
    public boolean[][] getEstMinee(){ 
        return estMinee;
    }
    public boolean[][] getVisibilite(){ 
        return visibilite;
    }
    public int[][] getEtatMarqueur(){ 
        return etatMarqueur;
    }
    public int[][] getNbMinesVoisines(){
        return nbMinesVoisines;
    }
}