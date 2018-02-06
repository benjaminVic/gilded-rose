package fr.esiea.al5;

public interface Item {

    void decreaseQuality();

    void increaseQuality();

    void trashQuality();

    boolean isSellInDatePassed();
}
