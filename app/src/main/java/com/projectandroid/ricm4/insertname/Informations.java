package com.projectandroid.ricm4.insertname;

/**
 * Created by hugo on 05/01/15.
 */
public class Informations {

    public enum Fonc{
        CINEMA,
        HORAIRE,
        GPS
    }

    private static String film = "The hobbit";
    private static String ville = "Grenoble";
    private static Fonc fonc;

    public static void setFilm(String f) {
        film = f;
    }

    public static String getFilm() {
        return film;
    }

    public static void setVille(String v) {
        ville = v;
    }

    public static String getVille() {
        return ville;
    }

    public static void setFonc(Fonc f) {
        fonc = f;
    }

    public static Fonc getFonc() {
        return fonc;
    }

}
