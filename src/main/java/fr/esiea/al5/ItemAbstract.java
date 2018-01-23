package fr.esiea.al5;

public abstract class ItemAbstract implements Item {

    private final String name;

    private int sellIn;

    private int quality;

    private final boolean conjured;

    /**
     *
     * @param name
     * @param sellIn
     * @param quality
     * @param conjured
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
        if (this.quality >= 0) {
            this.quality = this.quality - 1;
            if (this.sellIn <= 0 && this.quality > 0) {
                this.quality = this.quality - 1;
            }
        }
    }

    /**
     * Increase quality of an item by 1 up to 50.
     */
    public void increaseQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    public void reduceSellIn(){
        //TODO
        this.sellIn = this.sellIn - 1;
    }

    /**
     * Return the name of the item.
     * @return String : Name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return wether the item is conjured.
     * @return boolean : Conjured state
     */
    public boolean isConjured() {
        return conjured;
    }
}
