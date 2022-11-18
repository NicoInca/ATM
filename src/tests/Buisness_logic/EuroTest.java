package tests.Buisness_logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
            test = new Euro(-1, 10);
            assertEquals(test.getValore(), -110);
        }
        {// Test 4: Euro 100
            test = new Euro(2, -100);
            assertEquals(test.getValore(), 100);
        }
        {// Test 5: Euro 100
            test = new Euro(1);
            assertEquals(test.getValore(), 100);
        }
        {// Test 6: Euro 327
            test = new Euro(3.27);
            assertEquals(test.getValore(), 327);
        }
        {// Test 7: Euro -200
            test = new Euro(-2);
            assertEquals(test.getValore(), -200);
        }
        {// Test 8: -132
            test = new Euro(-1.32);
            assertEquals(test.getValore(), -132);
        }
        {// Test 9: 0
            test = new Euro(0, 0);
            assertEquals(test.getValore(), 0);
        }
        {// Test 10: 0
            test = new Euro(0);
            assertEquals(test.getValore(), 0);
        }
        
    }

    @Test
    public void testMinoreDi() {

    }

    @Test
    public void testSomma() {
        test = new Euro(0);
    }

    @Test
    public void testSottrai() {
        test = new Euro(60);
        Euro sconto = new Euro (9,99);
        assertEquals(test.sottrai(sconto).getValore(), 5001, 0);
    }

    @Test
    public void testStampa() {
        test = new Euro(23, 50);
        assertEquals(test.stampa(), "23.5 euro");
    }

    @Test
    public void testUgualeA() {
        Euro compare = new Euro(1.20);
        test = new Euro(1, 20);
        assertTrue(compare.ugualeA(test));
    }
}
