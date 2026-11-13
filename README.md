# Démineur

Le jeu du Démineur en Java (Swing), avec une grille configurable, la sauvegarde de la partie en cours et un thème graphique personnalisé (tons sable et vert).

Projet réalisé pour la **SAÉ 2.1** du BUT Informatique (IUT de Fontainebleau, 2025-2026).

**Auteurs :** Ildevert Nkouka, Tiago Alves--Le Du

## Fonctionnalités

- **Menu d'accueil** : Nouvelle partie, Reprendre (actif seulement s'il existe une sauvegarde), Quitter
- **Grille configurable** : de 4 à 30 lignes et de 4 à 30 colonnes, de 1 mine jusqu'à (cases − 1) mines
- **Jeu** :
  - clic gauche : révèle une case ; une case sans mine voisine révèle automatiquement ses voisines
  - clic droit : fait défiler drapeau ⚑ → point d'interrogation ? → vide
  - compteur de mines restantes et de coups joués
- **Fin de partie** : toutes les mines sont révélées en cas de défaite ; message « Gagné ! » quand toutes les cases sûres sont découvertes
- **Sauvegarde** : le bouton « Sauvegarder » enregistre la partie dans `sauvegarde.txt` ; elle est supprimée à la fin de la partie ou au lancement d'une nouvelle

## Prérequis

- Java (JDK 8 ou plus récent) avec `javac`
- `make` (facultatif)

## Compilation et lancement

À lancer **depuis le dossier du projet** (le logo `logo_bombe.png` et la sauvegarde sont lus dans le dossier courant) :

```bash
make        # compile tous les fichiers .java
make run    # compile puis lance le jeu
make clean  # supprime les fichiers .class
```

Sans `make` :

```bash
javac *.java
java Main
```

## Organisation du code

| Fichier | Rôle |
|---|---|
| `Main.java` | Point d'entrée |
| `FenetrePrincipal.java` | Fenêtre unique ; bascule entre menu, configuration et jeu |
| `PanneauMenu.java`, `ConsommateurMenu.java` | Écran d'accueil et ses actions |
| `PanneauConfig.java`, `ConsommateurConfig.java` | Choix du nombre de lignes, colonnes et mines |
| `PanneauJeu.java` | Écran de jeu : compteurs et bouton de sauvegarde |
| `Grille.java` | Placement des mines, calcul des voisins, propagation, victoire |
| `Cases.java` | Une case de la grille et son affichage |
| `GestionSouris.java` | Clics gauche et droit sur les cases |
| `SauvegardePartie.java` | Écriture et lecture de la sauvegarde (flux binaire) |
| `Style.java`, `BoutonMenu.java` | Couleurs et boutons personnalisés |

## Documentation

- `Rapport_De_Projet_SAE21_2025.pdf` : rapport de projet (parcours joueur, choix graphiques, architecture, sauvegarde)
- `Diagramme_class_demineur.mdj` : diagramme de classes (StarUML)
