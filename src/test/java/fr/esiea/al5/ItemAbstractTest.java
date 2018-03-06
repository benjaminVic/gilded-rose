package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;


public class ItemAbstractTest {

    @Test
    public void testToString() {
        ItemAbstract item = ItemFactory.createItem("apple",-1, 10, false);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.toString())
                .as("Item Printed")
                .isEqualTo("\tName : apple" +
                        "\n\tSellIn : -1" +
                        "\n\tQuality : 10" +
                        "\n\tConjured : false");
    }

    @ParameterizedTest
    @CsvSource({
        "2, 10, false, 9, 1",
            "-1, 10, false, 8, -2",
            "2, 10, true, 8, 1",
            "-1, 10, true, 6, -2",
            "2, 0, false, 0, 1"
    })
    public void nonSpecificObjectQualityAndPriceUpdate(int sellIn, int quality, boolean conjured, int expectedQuality, int expectedSellIn) {
        ItemAbstract item = new ItemAbstract("apple", sellIn, quality, conjured);
        Assert.assertTrue(item instanceof ItemAbstract);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(expectedQuality);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(expectedSellIn);

        softly.assertThat(item.getName())
                .as("apple name")
                .isEqualTo("apple");

        softly.assertAll();
    }

    @Test
    public void testSellInPassed() {
        ItemAbstract item = new ItemAbstract("apple",0, 10, false);

        GildedRose tavern = new GildedRose();
        tavern.addItem(item);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(8);
        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(-1);

        softly.assertAll();

    }

    @Test
    public void testConjuredQualityReduction() {
        ItemAbstract item = new ItemAbstract("apple",0, 10, true);
        ArrayList<ItemAbstract> items = new ArrayList<>();
        items.add(item);

        GildedRose tavern = new GildedRose();
        tavern.addAllItem(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.isConjured())
                .as("Apple being conjured")
                .isTrue();
        softly.assertThat(item.getQuality())
                .as("Conjured apple quality")
                .isEqualTo(6);
        softly.assertThat(item.getSellIn())
                .as("Conjured apple price")
                .isEqualTo(-1);
    }


}