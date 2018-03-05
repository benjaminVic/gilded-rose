package fr.esiea.al5;

public interface Item {

    void updateItemQuality();

    void decreaseQuality();

    void increaseQuality();

    void trashQuality();

    boolean isSellInDatePassed();
}
