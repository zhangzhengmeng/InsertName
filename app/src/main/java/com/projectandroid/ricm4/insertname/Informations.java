package com.projectandroid.ricm4.insertname;

/**
 * Created by hugo on 05/01/15.
 */
public class Informations {

    private static String film = "The hobbit";
    private static String ville = "Grenoble";

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

}
