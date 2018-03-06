package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ItemBackstagePassTest {

    @Test
    public void testObjectProperty(){
        ItemAbstract item = ItemFactory.createItem("Backstage",11, 10, false);
        Assert.assertTrue(item instanceof ItemBackstagePass);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getName())
                .as("Backstage")
                .isEqualTo("Backstage");

        softly.assertThat(item.getSellIn())
                .as("Backstage passes to a TAFKAL80ETC concert price")
                .isEqualTo(11);

        softly.assertThat(item.getQuality())
                .as("Backstage passes to a TAFKAL80ETC concert quality")
                .isEqualTo(10);

        softly.assertThat(item.isConjured())
                .as("Backstage passes to a TAFKAL80ETC conjuring")
                .isFalse();

        softly.assertAll();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 50, 50, 1",
            "10, 0, 2, 9",
            "5, 0, 3, 4",
            "0, 0, 0 ,0",
            "15, 12, 13, 14"
    })
    public void testBackstagePassesUpdate(int sellIn, int quality, int expectedQuality, int expectedSellIn){
        ItemBackstagePass item = new ItemBackstagePass(sellIn, quality);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getQuality())
                .as("Backstage passes to a TAFKAL80ETC concert quality")
                .isEqualTo(expectedQuality);

        softly.assertThat(item.getSellIn())
                .as("Backstage passes to a TAFKAL80ETC concert price")
                .isEqualTo(expectedSellIn);

        softly.assertAll();
    }
}
