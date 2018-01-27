package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void nonSpecificObjectQualityAndPriceDecreaseByone() {
        ItemAbstract item = new ItemAbstract("apple",2, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(9);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void qualityCantBeNegative() {
        ItemAbstract item = new ItemAbstract("apple",2, -5, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(-5);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void qualityCantBeMore50() {
        ItemAbstract item = new ItemAbstract("Aged Brie",2, 50, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(50);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void qualityMore50() {
        ItemAbstract item = new ItemAbstract("apple", 2, 20, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(19);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(1);

        softly.assertAll();
    }

    @Test
    public void sellIn6() {
        ItemAbstract item = new ItemAbstract("apple",6, 2, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(1);

        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(5);

        softly.assertAll();
    }

    @Test
    public void agedBrieAfterOneDay() {
        ItemAbstract item = new ItemAbstract("Aged Brie",10, 0, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(1);

        softly.assertAll();

    }

    @Test
    public void agedBrieAfter50Day() {
        ItemAbstract item = new ItemAbstract("Aged Brie",50, 0, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        for(int i=0; i<50; i++)
            tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(50);

        softly.assertAll();

    }

    @Test
    public void agedBrieBefore50Day() {
        ItemAbstract item = new ItemAbstract("Aged Brie",1 ,0, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        for(int i=0; i<50; i++)
            tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(50);


        softly.assertAll();

    }

    @Test
    public void concertSellinIn1() {
        ItemAbstract item = new ItemAbstract("Backstage passes to a TAFKAL80ETC concert",1, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(13);
        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(0);

        softly.assertAll();

    }

    @Test
    public void concertSellinIn10() {
        ItemAbstract item = new ItemAbstract("Backstage passes to a TAFKAL80ETC concert",10, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(12);
        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(9);

        softly.assertAll();

    }

    @Test
    public void concertSellinInMinus1(){
        ItemAbstract item = new ItemAbstract("Backstage passes to a TAFKAL80ETC concert",-1, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.getQuality())
                .as("apple quality")
                .isEqualTo(0);
        softly.assertThat(item.getSellIn())
                .as("apple price")
                .isEqualTo(-2);

        softly.assertAll();

    }

    @Test
    public void oneItemMinusSellin() {
        ItemAbstract item = new ItemAbstract("apple",-1, 10, false);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

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
    public void conjuredQualityReduction() {
        ItemAbstract item = new ItemAbstract("apple",-1, 10, true);
        ItemAbstract[] items = new ItemAbstract[]{item};

        GildedRose tavern = new GildedRose(items);
        tavern.updateQuality();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(item.isConjured()).as("Apple being conjured").isTrue();
        softly.assertThat(item.getQuality()).as("Conjured apple quality").isEqualTo(6);
        softly.assertThat(item.getSellIn()).as("Conjured apple price").isEqualTo(-2);
    }

    @Test
    public void myTestString() {
        ItemAbstract item = new ItemAbstract("apple",-1, 10, false);
        System.out.println(item.toString());
    }

    @Test
    public void myTestApp() {
        App t = new App();
        String [] args = { "test1", "test2", "test3" };
        t.main(args);
    }

}
