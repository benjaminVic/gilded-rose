package fr.esiea.al5;

class GildedRose {
    ItemAbstract[] items;

    public GildedRose(ItemAbstract[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(SpecialItems.AGED_BRIE.getName())
                    && !items[i].getName().equals(SpecialItems.BACKSTAGE_PASS.getName())
                    &&!items[i].getName().equals(SpecialItems.SULFURAS.getName())) {
                items[i].decreaseQuality();
            } else {
                items[i].increaseQuality();

                if (items[i].getName().equals(SpecialItems.BACKSTAGE_PASS.getName())) {
                    if (items[i].getSellIn() < 11) {
                        items[i].increaseQuality();
                    }

                    if (items[i].getSellIn() < 6) {
                        items[i].increaseQuality();
                    }
                }
            }

            if (!items[i].getName().equals(SpecialItems.SULFURAS.getName())) {
                items[i].reduceSellIn();
            }

            if (items[i].isSellInDatePassed()) {
                if (!items[i].getName().equals(SpecialItems.AGED_BRIE.getName())) {
                    if (!items[i].getName().equals(SpecialItems.BACKSTAGE_PASS.getName())) {
                        if (!items[i].getName().equals(SpecialItems.SULFURAS.getName())) {
                            items[i].decreaseQuality();
                        }
                    } else {
                        items[i].trashQuality();
                    }
                } else {
                    items[i].increaseQuality();
                }
            }
        }
    }
}
