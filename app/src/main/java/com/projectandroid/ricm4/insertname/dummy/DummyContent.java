package com.projectandroid.ricm4.insertname.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jsoup.Actions;
import jsoup.Cinema;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        Actions a = new Actions();
        String ville = "Grenoble";
        List<Cinema> cf = new ArrayList<Cinema>(a.getCinemas(ville));
        for (int i = 0; i < cf.size(); i++) {
            addItem(new DummyItem(String.valueOf(i), cf.get(i).getName(), cf.get(i).getDescription()));
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
