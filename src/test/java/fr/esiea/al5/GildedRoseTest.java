package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void nonSpecificObjectQualityAndPriceDecreaseByone() {
        Item item = new Item("apple",2, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(9);

        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

    @Test
    public void qualityCantBeNegative() {
        Item item = new Item("apple",2, -5);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(-5);

        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

    @Test
    public void qualityCantBeMore50() {
        Item item = new Item("Aged Brie",2, 50);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(50);

        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

    @Test
    public void qualityMore50() {
        Item item = new Item("apple",2, 20);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(19);

        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

    @Test
    public void sellIn6() {
        Item item = new Item("apple",6, 2);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(1);

        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(5);

        solftly.assertAll();
    }

    @Test
    public void agedBrieAfterOneDay() {
        Item item = new Item("Aged Brie",10, 0);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(1);

        solftly.assertAll();

    }

    @Test
    public void agedBrieAfter50Day() {
        Item item = new Item("Aged Brie",50, 0);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        for(int i=0; i<50; i++)
            tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(50);

        solftly.assertAll();

    }

    @Test
    public void agedBrieBefore50Day() {
        Item item = new Item("Aged Brie",1 ,0);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        for(int i=0; i<50; i++)
            tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(50);


        solftly.assertAll();

    }

    @Test
    public void concertSellinIn1() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",1, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(13);
        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(0);

        solftly.assertAll();

    }

    @Test
    public void concertSellinIn10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",10, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(12);
        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(9);

        solftly.assertAll();

    }

    @Test
    public void concertSellinInMinus1(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",-1, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(0);
        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(-2);

        solftly.assertAll();

    }

    @Test
    public void oneItemMinusSellin() {
        Item item = new Item("apple",-1, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("apple quality")
                .isEqualTo(8);
        solftly.assertThat(item.sellIn)
                .as("apple price")
                .isEqualTo(-2);

        solftly.assertAll();

    }

}
