package fr.esiea.al5;

public class ItemAgedBrie extends ItemAbstract{

    public ItemAgedBrie(int sellIn, int quality, boolean conjured) { super(SpecialItems.AGED_BRIE.getName(), sellIn, quality, false); }

    @Override
    public String getName() {
    return SpecialItems.AGED_BRIE.getName();
    }

    @Override
    public void updateItemQuality() {
        // "Aged Brie" actually increases in Quality the older it gets
        if (!isSellInDatePassed()) {
            reduceSellIn();
            increaseQuality();
        }

        else increaseQuality();

    }
}
