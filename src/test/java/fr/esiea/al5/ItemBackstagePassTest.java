package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

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

    @Test
    public void testQualityCantBeMore50() {
        ItemBackstagePass item = new ItemBackstagePass(2, 50);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("Backstage quality")
                .isEqualTo(50);

        softly.assertThat(item.getSellIn())
                .as("Backstage Days left")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void testBackstagePassesUpdateDay10To5() {
        ItemBackstagePass item = new ItemBackstagePass(10, 0);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("Backstage")
                .isEqualTo(2);
        softly.assertThat(item.getSellIn())
                .as("Backstage")
                .isEqualTo(9);

        softly.assertAll();

    }

    @Test
    public void testBackstagePassesUpdateDay5To1() {
        ItemBackstagePass item = new ItemBackstagePass(5, 0);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("Backstage")
                .isEqualTo(3);
        softly.assertThat(item.getSellIn())
                .as("Backstage")
                .isEqualTo(4);

        softly.assertAll();

    }

    @Test
    public void testBackstagePassesUpdateDay0AndLess(){
        ItemBackstagePass item = new ItemBackstagePass(0, 0);

        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getQuality())
                .as("Backstage quality")
                .isEqualTo(0);
        softly.assertThat(item.getSellIn())
                .as("Backstage Day left")
                .isEqualTo(0);

        softly.assertAll();

    }

    @Test
    public void testBackstagePassesUpdate(){
        ItemBackstagePass item = new ItemBackstagePass(15, 12);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getQuality())
                .as("Backstage passes to a TAFKAL80ETC concert quality")
                .isEqualTo(13);

        softly.assertThat(item.getSellIn())
                .as("Backstage passes to a TAFKAL80ETC concert price")
                .isEqualTo(14);

        softly.assertAll();
    }
}
