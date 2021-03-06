package Game;

import Outils.Contenu;
import Outils.Directions;
import Outils.Fonctions;
import com.sun.prism.impl.shape.ShapeUtil;

import static Outils.Directions.*;
import static Outils.Fonctions.checkTraversable;

public class Player {

    private String nomJoueur;
    private int recordJoueur; // A utiliser si on finit plus tot avec une co BDD

    private int[] coordonnes;

    private Contenu PACMAN = Outils.Contenu.PACMAN;

    private Directions precedenteDirection;




    public int getRecordJoueur() {
        return recordJoueur;
    }

    public void setRecordJoueur(int recordJoueur) {
        this.recordJoueur = recordJoueur;
    }



    public Player() { }


    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }


    public int[] getCoordonnes() {
        return coordonnes;
    }

    public void setCoordonnes(int[] coordonnes) {
        this.coordonnes = coordonnes;
    }

    public Directions getPrecedenteDirection() {
        return precedenteDirection;
    }

    public void setPrecedenteDirection(Directions precedenteDirection) {
        this.precedenteDirection = precedenteDirection;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nomJoueur='" + nomJoueur + '\'' +
                ", recordJoueur=" + recordJoueur +
                '}';
    }

    public Player(String nomJoueur,int[] coo){

        this.coordonnes=coo;
        this.precedenteDirection = null;
        this.nomJoueur = nomJoueur;
    }



    public Contenu[][] choixDirection(Contenu[][] planche){

        String toucheEnfoncee = null;
        Directions dir;


        switch (toucheEnfoncee){

            case "fleche de droite":
                dir = DROITE;
                break;
            case "fleche du bas":
                dir = BAS;
                break;
            case "fleche de gauche":
                dir = GAUCHE;
                break;
            case "fleche du haut":
                dir = HAUT;
                break;
            default:
                dir = this.precedenteDirection;
        }

        this.precedenteDirection = dir;

        int x = this.coordonnes[0];
        int y = this.coordonnes[1];

        Contenu[] contenuAutour = Fonctions.scanContenuAutour(planche,x,y);


        if(dir == GAUCHE && checkTraversable(dir, contenuAutour)){



        }else if(dir == DROITE && checkTraversable(dir, contenuAutour)){


        }else if (dir == HAUT && checkTraversable(dir, contenuAutour)){


        }else if (dir == BAS && checkTraversable(dir, contenuAutour)){



        }










    }




}
