package fr.esiea.al5;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert.*;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void testApp() {
        App t = new App();
        String [] args = { "test1", "test2", "test3" };
        t.main(args);
    }

}
