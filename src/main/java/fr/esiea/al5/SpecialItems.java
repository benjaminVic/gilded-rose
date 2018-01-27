package fr.esiea.al5;

public enum SpecialItems {

    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert");

    private final String name;

    SpecialItems(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
