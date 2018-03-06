package fr.esiea.al5;

public class ItemFactory {

    /**
     * Private constructor to make 100% Test Coverage on Coveralls
     */
    private ItemFactory(){}

    /**
     * Factory to build any item, handles special cases
     * @param name : Name of the Intended item, criteria to generate specific Item
     * @param sellin : Number of days until which the item is sold
     * @param quality : Value of the Item
     * @param cursed : Curse status of the item
     * @return
     */
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