package tests.Buisness_logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Buisness_logic.Euro;

public class EuroTest {

    Euro test = null;

    @Test
    public void testGetValore() {

        //NOTE: I'm using scopes to delete objects as long as I don't need them
        
        {// Test 1: Euro 110
            test = new Euro(1, 10);
            assertEquals(test.getValore() , 110);
        }
        {// Test 2: Euro 200
            test = new Euro(2, 0);
            assertEquals(test.getValore(), 200);
        }
        {// Test 3: Euro -110
            test = new Euro(-1, -10);
            assertEquals(test.getValore(), -110);
        }
    }

    @Test
    public void testMinoreDi() {

    }

    @Test
    public void testSomma() {

    }

    @Test
    public void testSottrai() {

    }

    @Test
    public void testStampa() {

    }

    @Test
    public void testUgualeA() {

    }
}
