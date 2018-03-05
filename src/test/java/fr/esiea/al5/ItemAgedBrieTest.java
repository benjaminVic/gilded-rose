package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

public class ItemAgedBrieTest {


    @Test
    public void testObjectProperty() {
        ItemAbstract item = ItemFactory.createItem("Aged Brie",2, 7, false);
        Assert.assertTrue(item instanceof ItemAgedBrie);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getName())
                .as("Aged Brie name")
                .isEqualTo("Aged Brie");

        softly.assertThat(item.getQuality())
                .as("Aged Brie quality")
                .isEqualTo(7);

        softly.assertThat(item.getSellIn())
                .as("Aged Brie price")
                .isEqualTo(2);

        softly.assertThat(item.isConjured())
                .as("Aged Brie conjuring")
                .isFalse();

        softly.assertAll();
    }
    @Test
    public void testQualityCantBeMore50() {
        ItemAgedBrie item = new ItemAgedBrie(2, 50);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("Aged Brie quality")
                .isEqualTo(50);

        softly.assertThat(item.getSellIn())
                .as("Aged Brie Days left")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void testAgedBrieAfterUpdate() {
        ItemAgedBrie item = new ItemAgedBrie( 2, 0);

        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getSellIn())
                .as("Aged Brie")
                .isEqualTo(1);

        softly.assertThat(item.getQuality())
                .as("Aged Brie")
                .isEqualTo(1);

        softly.assertAll();

    }

    @Test
    public void testAgedBrieAfter50DaysFromDay100() {
        ItemAgedBrie item = new ItemAgedBrie(100, 0);

        for (int i = 0; i < 75; i++) item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getSellIn())
                .as("Aged Brie")
                .isEqualTo(25);

        softly.assertThat(item.getQuality())
                .as("Aged Brie")
                .isEqualTo(50);

        softly.assertAll();

    }

    @Test
    public void testAgedBrieAfter50DaysFromDay1() {
        ItemAgedBrie item = new ItemAgedBrie(1, 0);

        for (int i = 0; i < 75; i++) item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getSellIn())
                .as("Aged Brie")
                .isEqualTo(-1);

        softly.assertThat(item.getQuality())
                .as("Aged Brie")
                .isEqualTo(50);


        softly.assertAll();

    }
}
