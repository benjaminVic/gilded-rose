package fr.esiea.al5;

public interface Item {

    /**
     * Updating the quality of and item and reducing it sellIn date
     */
    void updateItemQuality();

    /**
     * Reduction of item quality
     */
    void decreaseQuality();

    /**
     * Increase of the Item quality
     */
    void increaseQuality();

    /**
     * Reducing quality to it's minimum
     */
    void trashQuality();

    /**
     * Indicates whether the sellIn date is passed
     * @return True if the item is passed
     */
    boolean isSellInDatePassed();

    /**
     * Prints informations regarding the object
     * @return Sting containing all info on the item
     */
    String toString();
}
