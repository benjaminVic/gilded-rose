package fr.esiea.al5;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SpecialItemsTest extends TestCase {

    public SpecialItemsTest(String testName) {
        super(testName);
    }

    @org.junit.Test
    public void testGetName(){
        assertTrue(SpecialItems.BACKSTAGE_PASS.getName()
                == "Backstage");
    }
}
