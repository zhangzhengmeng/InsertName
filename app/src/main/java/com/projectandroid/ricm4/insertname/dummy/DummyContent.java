package com.projectandroid.ricm4.insertname.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projectandroid.ricm4.insertname.Informations;
import com.projectandroid.ricm4.insertname.MainActivity;
import jsoup.Actions;
import jsoup.Cinema;
import jsoup.Horraire;

import android.app.Activity;
import android.content.Intent;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */



    public class DummyContent extends Activity{


    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static List<Horraire> addInformation() {

        Actions a = new Actions();
        List<Horraire> cf = new ArrayList<Horraire>(a.getCinema(Informations.getVille(), Informations.getFilm()));
        /*for (int i = 0; i < cf.size(); i++) {
            System.out.println("zbra\n");
            addItem(new DummyItem(String.valueOf(i), cf.get(i).getName(), cf.get(i).getDescription()));
            cf.get(i).afficher();
        }*/
        return cf;
    }

    static{
      // Add 3 sample items.
        /*
        addItem(new DummyItem("1", "Item 1","d1"));
        addItem(new DummyItem("2", "Item 2","d2"));
        addItem(new DummyItem("3", "Item 3","d3"));
        */
        /*Intent myI= getIntent();
        String ville = myI.getStringExtra("ville");
        System.out.println("aaaa"+ville);*/

        List<Horraire> cf = addInformation();
        for (int i = 0; i < cf.size(); i++) {
            addItem(new DummyItem(String.valueOf(i), cf.get(i).getName(), cf.get(i).getHorraire()));
            cf.get(i).afficher();
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public String detail;

        public DummyItem(String id, String content, String detail) {
            this.id = id;
            this.content = content;
            this.detail = detail;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
