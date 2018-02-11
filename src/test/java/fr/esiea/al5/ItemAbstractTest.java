package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;


public class ItemAbstractTest {

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

}