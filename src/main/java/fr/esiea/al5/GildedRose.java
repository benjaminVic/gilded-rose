package fr.esiea.al5;

class GildedRose {
    ItemAbstract[] items;

    public GildedRose(ItemAbstract[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (ItemAbstract item : items) {item.updateItemQuality();}

    }
}
