package com.projectandroid.ricm4.insertname;

import java.text.Normalizer;

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
        String tmp = Normalizer.normalize(film, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        return tmp;
    }

    public static void setVille(String v) {
        ville = v;
    }

    public static String getVille() {
        String tmp = Normalizer.normalize(ville, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        return tmp;
    }

    public static void setFonc(Fonc f) {
        fonc = f;
    }

    public static Fonc getFonc() {
        return fonc;
    }

}
