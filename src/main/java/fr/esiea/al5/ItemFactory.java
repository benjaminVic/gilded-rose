package fr.esiea.al5;

public class ItemFactory {

    public static ItemAbstract createItem(String name, int sellin, int quality, boolean cursed) {
        if (name.toLowerCase().equals(SpecialItems.BACKSTAGE_PASS.getName().toLowerCase())) {
            return new ItemBackstagePass(sellin, quality);
        }
        if (name.toLowerCase().equals(SpecialItems.AGED_BRIE.getName().toLowerCase())) {
            return new ItemAgedBrie(sellin, quality);
        }
        if (name.toLowerCase().equals(SpecialItems.SULFURAS.getName().toLowerCase())) {
            return new ItemSulfuras(sellin, quality);
        }
        return new ItemAbstract(name, sellin, quality, cursed);
        }
    }