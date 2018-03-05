package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;


public class ItemAbstractTest {

    @Test
    public void testToString() {
        ItemAbstract item = new ItemAbstract("apple",-1, 10, false);
        System.out.println(item.toString());
    }

    @Test
    public void nonSpecificObjectQualityAndPriceUpdate() {
        ItemAbstract item = new ItemAbstract("apple", 2, 10, false);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(9);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertThat(item.getName())
                .as("apple name")
                .isEqualTo("apple");

        softly.assertAll();
    }

        @Test
    public void nonSpecificExpiredObjectQualityAndPriceUpdate() {
        ItemAbstract item = new ItemAbstract("apple", -1, 10, false);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(8);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(-2);

        softly.assertAll();
    }

    @Test
    public void nonSpecificConjuredObjectQualityAndPriceUpdate() {
        ItemAbstract item = new ItemAbstract("apple", 2, 10, true);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(8);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertAll();
    }

        @Test
    public void nonSpecificConjuredAndExpiredObjectQualityAndPriceUpdate() {
        ItemAbstract item = new ItemAbstract("apple", -1, 10, true);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(6);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(-2);

        softly.assertAll();
    }
    @Test
    public void testItemUpdate() {
        ItemAbstract item = new ItemAbstract("apple",2, 1, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getSellIn())
                .as("apple days left")
                .isEqualTo(1);

        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(0);

        softly.assertAll();
    }

    @Test
    public void testSellInPassed() {
        ItemAbstract item = new ItemAbstract("apple",0, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
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
    public void testQualityCantBeNegative() {
        ItemAbstract item = new ItemAbstract("apple",2, 0, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(0);

        softly.assertThat(item.getSellIn())
                .as("apple days left")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void testConjuredQualityReduction() {
        ItemAbstract item = new ItemAbstract("apple",0, 10, true);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
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