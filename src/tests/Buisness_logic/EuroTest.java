package tests.Buisness_logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Buisness_logic.Euro;

public class EuroTest {
    @Test
    public void testGetValore() {
        // Test 1: Euro 110
        Euro test1 = new Euro(1, 10);
        assertEquals(test1.getValore() , 110);
        // Test 2: Euro 200
        Euro test2 = new Euro(2, 0);
        assertEquals(test2.getValore(), 200);
        // Test 3: Euro -110
        Euro test3 = new Euro(-1, -10);
        assertEquals(test3.getValore(), -110);
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
