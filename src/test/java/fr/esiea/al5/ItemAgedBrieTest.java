package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class ItemAgedBrieTest {


    @Test
    public void testObjectProperty() {
        ItemAgedBrie item = new ItemAgedBrie("Aged Brie", 2, 7, false);

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
        ItemAgedBrie item = new ItemAgedBrie("Aged Brie", 2, 50, false);
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
        ItemAgedBrie item = new ItemAgedBrie("Aged Brie", 2, 0, false);

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
        ItemAgedBrie item = new ItemAgedBrie("Aged Brie", 100, 0, false);

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
        ItemAgedBrie item = new ItemAgedBrie("Aged Brie", 1, 0, false);

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
