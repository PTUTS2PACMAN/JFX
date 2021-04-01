package Outils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Fonctions {


    /**
     * Utilise pour convertir un String vers un char[][] la fonction de Matthew Sant - https://stackoverflow.com/questions/27095380/convert-string-to-2d-char-array
     * @param pathFichier le lien du fichier à lire
     * @return unTableau 2D de char
     * @throws FileNotFoundException fichier introuvable
     */
    public static char[][] mappingMap(String pathFichier) throws FileNotFoundException {

        String temp = null;
        String sautLigne = "|";
        String toString ="";

        File map = new File(pathFichier);
        Scanner scan = new Scanner(map);

        while (scan.hasNextLine()){

            temp = scan.nextLine();
            toString += temp;
            toString += sautLigne;

        }

        String[] lignes = toString.split("|");
        char[][] chars = new char[lignes.length + 1][];
        for (int i = 0; i < lignes.length; i++) {
            String component = lignes[i];
            chars[i] = component.toCharArray();
        }
        chars[lignes.length] = new char[] { '\0' };

        return chars;

    }



    /**
     * Retourne un ArrayList des directions disponibles à partir d'une case
     *
     * @param toScan un tableau double de contenus [X][Y]
     * @param posX la position X
     * @param posY la position Y
     * @return un ArrayList avec les positions
     */
    public List<Directions> scanAutour(Contenu[][] toScan, int posX, int posY){

        List<Directions> toReturn = new ArrayList<Directions>();


        if(toScan[posX-1][posY] == Contenu.VIDE || toScan[posX-1][posY] == Contenu.BONBON  ||toScan[posX-1][posY] == Contenu.GROS_BONBON ){

            toReturn.add(Directions.GAUCHE);

        }
        if(toScan[posX+1][posY] == Contenu.VIDE || toScan[posX+1][posY] == Contenu.BONBON  ||toScan[posX+1][posY] == Contenu.GROS_BONBON ){

            toReturn.add(Directions.DROITE);

        }

        if(toScan[posX][posY-1] == Contenu.VIDE || toScan[posX][posY-1] == Contenu.BONBON  ||toScan[posX][posY-1] == Contenu.GROS_BONBON ){

            toReturn.add(Directions.BAS);

        }
        if(toScan[posX][posY+1] == Contenu.VIDE || toScan[posX][posY+1] == Contenu.BONBON  ||toScan[posX][posY+1] == Contenu.GROS_BONBON ){

            toReturn.add(Directions.HAUT);

        }



        return toReturn;

    }

    /**
     * Parse la map Brute (à l'init de Board) en un tableau de attribContenu
     * @param bruteMap le char[][] de la map brute
     * @return le Contenu[][] Correspondant
     */

    public static Contenu[][] mapParser(char[][] bruteMap){

        int X = Constantes.getNombreLignes();
        int Y = Constantes.getNombreColonnes();

        Contenu[][] toReturn = new Contenu[X][Y];

        for (int k = 0; k < X; k++) {

            for (int i = 0; i < Y; i++) {

                switch (bruteMap[k][i]){

                    case 0:
                        toReturn[k][i] = Contenu.VIDE;
                        break;
                    case 1:
                        toReturn[k][i] = Contenu.MUR;
                        break;
                    case 2:
                        toReturn[k][i] = Contenu.BONBON;

                    case 8:
                        toReturn[k][i] = Contenu.PORTE;
                        break;

                    case 9:
                        toReturn[k][i] = Contenu.ZONE_SPAWN;
                        break;
                    default:
                        toReturn[k][i] = Contenu.INCONNU_ERREUR;
                }


            }

        }
        return toReturn;

    }

    /**
     *
     * @param toScan Board actuelle format Contenu[][]
     * @param posX Position X
     * @param posY Position Y
     * @return Le contenu de la case
     */
    public Contenu scanPos(Contenu[][] toScan, int posX, int posY){

        return toScan[posX][posY];

    }

    public Contenu[][] actualisationTab(){

        Contenu[][] toReturn = new Contenu[Constantes.getNombreLignes()][Constantes.getNombreColonnes()];



        return toReturn;
    }



}
