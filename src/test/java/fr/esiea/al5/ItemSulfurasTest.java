package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;

public class ItemSulfurasTest {

    @Test
    public void testObjectProperty(){
    	ItemSulfuras item = new ItemSulfuras("Sulfuras", 0, 80, false);

        SoftAssertions softly = new SoftAssertions();
		softly.assertThat(item.getName())
                .as("sulfuras name")
                .isEqualTo("Sulfuras");

        softly.assertThat(item.getQuality())
                .as("sulfuras quality")
                .isEqualTo(80);

        softly.assertThat(item.getSellIn())
                .as("sulfuras price")
                .isEqualTo(0);

        softly.assertThat(item.isConjured())
                .as("sulfuras conjuring")
                .isFalse();

        softly.assertAll();
    }

    @Test
    public void testObjectQualityUpdate(){
        ItemSulfuras item = new ItemSulfuras("Sulfuras", 0, 80, false);
        item.updateItemQuality();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(item.getQuality())
                .as("sulfuras quality")
                .isEqualTo(80);

        softly.assertThat(item.getSellIn())
                .as("sulfuras price")
                .isEqualTo(0);

        softly.assertAll();
    }
}
