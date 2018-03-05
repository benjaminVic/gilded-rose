package fr.esiea.al5;

import java.util.ArrayList;

class GildedRose {
    protected ArrayList<ItemAbstract> items = new ArrayList<>();

    public GildedRose() {
        //empty Constructor
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateItemQuality();
        }
    }

    public void addAllItem(ArrayList<ItemAbstract> items) {
        this.items.addAll(items);
    }

    public void addItem(ItemAbstract item){
        this.items.add(item);
    }
}
