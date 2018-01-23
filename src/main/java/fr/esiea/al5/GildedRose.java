package fr.esiea.al5;

class GildedRose {
    ItemAbstract[] items;

    public GildedRose(ItemAbstract[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals("Aged Brie")
                    && !items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].decreaseQuality();
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            items[i].increaseQuality();
                        }

                        if (items[i].sellIn < 6) {
                            items[i].increaseQuality();
                        }
                    }
                }
            }

            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].getName().equals("Aged Brie")) {
                    if (!items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].decreaseQuality();
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    items[i].increaseQuality();
                }
            }
        }
    }
}
