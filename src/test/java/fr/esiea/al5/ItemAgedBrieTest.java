package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "2, 50, 1, 1, 50",
            "2, 0, 1, 1, 1",
            "100, 0, 75, 25, 50",
            "1, 0, 75, -1, 50"
    })
    public void testAgedBrieUpdate(int sellIn, int quality, int numberOfUpdates, int expectedSellIn, int expectedQuality) {
        ItemAgedBrie item = new ItemAgedBrie(sellIn, quality);

        for (int i = 0; i < numberOfUpdates; i++) item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getSellIn())
                .as("Aged Brie")
                .isEqualTo(expectedSellIn);

        softly.assertThat(item.getQuality())
                .as("Aged Brie")
                .isEqualTo(expectedQuality);

        softly.assertAll();

    }

}
