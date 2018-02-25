package fr.esiea.al5;

public enum SpecialItems {

    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras"),
    BACKSTAGE_PASS("Backstage");

    private final String name;

    SpecialItems(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
