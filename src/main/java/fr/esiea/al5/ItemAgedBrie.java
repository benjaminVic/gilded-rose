package fr.esiea.al5;

public class ItemAgedBrie extends ItemAbstract{

    /**
     * Constructor of Aged Brie
     * @param sellIn : Date to sell the item
     * @param quality : Value of the item
     */
    public ItemAgedBrie(int sellIn, int quality) {
        super(SpecialItems.AGED_BRIE.getName(), sellIn, quality, false);
    }

    @Override
    /** {@inheritdoc} */
    public String getName() {
    return SpecialItems.AGED_BRIE.getName();
    }

    @Override
    /** {@inheritdoc} */
    public void updateItemQuality() {
        // "Aged Brie" actually increases in Quality the older it gets
        if (!isSellInDatePassed()) {
            reduceSellIn();
            increaseQuality();
        }

        else increaseQuality();

    }
}
