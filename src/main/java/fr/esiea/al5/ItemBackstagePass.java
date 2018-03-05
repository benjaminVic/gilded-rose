package fr.esiea.al5;

public class ItemBackstagePass extends ItemAbstract{

    /**
     * Constructor of the BackStagePass Item
     * @param sellIn : Number of days before sell date has passed
     * @param quality :
     */
    public ItemBackstagePass(int sellIn, int quality) {
        super(SpecialItems.BACKSTAGE_PASS.getName(), sellIn, quality, false);
    }

    @Override
    /** {@inheritdoc} */
    public String getName() {
        return SpecialItems.BACKSTAGE_PASS.getName();
    }

    @Override
    /** {@inheritdoc} */
    public void updateItemQuality() {
        // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        // Quality drops to 0 after the concert
        increaseQuality();

        if (getSellIn() > 0) reduceSellIn();

        if (getSellIn() < 10) increaseQuality();

        if (getSellIn() < 5) increaseQuality();

        if (getSellIn() < 1) trashQuality();
    }
}
