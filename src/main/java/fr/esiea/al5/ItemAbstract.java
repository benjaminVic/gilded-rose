package fr.esiea.al5;

public class ItemAbstract implements Item {

    private final String name;

    private int sellIn;

    private int quality;

    private final boolean conjured;

    /**
     * Item constructor
     * @param name : Name of the Item
     * @param sellIn : Number of days until which the item is sold
     * @param quality : Value of the Item
     * @param conjured : Curse Status of the item
     */
    public ItemAbstract(String name, int sellIn, int quality, boolean conjured) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured;
    }

    /**
     * Return the Items information
     * @return String : the name of the item, its price and its quality state.
     */
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    /**
     * Reduce quality of an item by 1 up to 0.
     */
    public void decreaseQuality() {
        if (this.qualityCanBeReduced()) {
            this.quality = this.quality - 1;
            if (this.isConjured() && this.qualityCanBeReduced()) {
                this.quality = this.quality - 1;
            }
        }
    }

    /**
     * Increase quality of an item by 1 up to 50.
     */
    public void increaseQuality() {
        if (qualityCanBeIncreased()) {
            this.quality = this.quality + 1;
        }
    }

    /**
     * Reduce quality to 0.
     */
    public void trashQuality(){
        this.quality = 0;
    }

    /**
     * Check wether the item quality can be reudced.
     * @return boolena : Return true if the quality can be reduced, else false.
     */
    private boolean qualityCanBeReduced() {
        return this.quality > 0;
    }

    /**
     * Check wether the item quality can be increased.
     * @return boolena : Return true if the quality can be increased, else false.
     */
    private boolean qualityCanBeIncreased() {
        return this.quality < 50;
    }

    /**
     * Reduce the numbers of days for an item sale.
     */
    public void reduceSellIn(){
        this.sellIn = this.sellIn - 1;
    }

    /**
     * Indicates whether and item is passedBy or not.
     * @return boolean :True if sellIn equal or inferior to 0.
     */
    public boolean isSellInDatePassed() {
        return (this.sellIn < 0);
    }

    /**
     * Returns the name of the item.
     * @return String : Name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the date in which the item has to be sold. Else will lose valuetwice as fast.
     * @return int : number of days before it has to be sold
     */
    public int getSellIn() {
        return this.sellIn;
    }

    /**
     * Returns the quality of the item.
     * @return int : Item quality
     */
    public int getQuality() {
        return this.quality;
    }

    /**
     * Returns whether the item is conjured.
     * @return boolean : Conjured state
     */
    public boolean isConjured() {
        return conjured;
    }

    /**
     * Update the Quality of an Item
     */
    public void updateItemQuality() {
        this.decreaseQuality();
        this.reduceSellIn();
        if ( this.isSellInDatePassed() ) {
            this.decreaseQuality();
        }
    }
}
