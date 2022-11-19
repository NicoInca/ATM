package tests.Buisness_logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Buisness_logic.Euro;

public class EuroTest {

    Euro test = null;
    Euro confronto = null;

    @Test
    public void testGetValore() {

        //NOTE: I'm using scopes to delete objects whenever I don't need them anymore
        
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

        {   // compare to null
            test = new Euro(120);
            confronto = null;
            assertThrows(IllegalArgumentException.class, () -> test.minoreDi(confronto));
        }

        {   // same amount
            test = new Euro(30);
            confronto = new Euro(30, 0);
            assertTrue("sono la stessa somma", test.minoreDi(confronto));
        }

        {   // compare to 0
            test = new Euro(40, 50);
            confronto = new Euro(0);
            assertFalse(test.minoreDi(confronto));
        }

        {   // compare negative to 0
            test = new Euro(-200);
            confronto = new Euro(0, 0);
            assertTrue(test.minoreDi(confronto));
        }

        {   // compare positive to negative
            test = new Euro(34);
            confronto = new Euro(-2, 60);
            assertFalse(test.minoreDi(confronto));
        }

    }

    @Test
    public void testSomma() {

        {   // sum null
            test = null;
            confronto = new Euro(1000);
            assertThrows(IllegalArgumentException.class, () -> confronto.somma(test));
        }

        {   // sum 0 to 0
        test = new Euro(0);
            confronto = new Euro(0, 0);
            assertEquals(test.somma(confronto).getValore(), 0);
        }

        {   // sum a negative
            test = new Euro(40);
            confronto = new Euro(-22, 10);
            assertEquals(test.somma(confronto).getValore(), 1790);
        }

        {   // sum euro with cents
            test = new Euro(30);
            confronto = new Euro(0, 50);
            assertEquals(test.somma(confronto).getValore(), 3050);
        }

        {   // sum and compare
            test = new Euro(-22);
            confronto = new Euro(-18);
            assertTrue(new Euro(-40).ugualeA(test.somma(confronto)));
        }

    }

    @Test
    public void testSottrai() {

        {   // sub null
            test = null;
            confronto = new Euro(1000);
            assertThrows(IllegalArgumentException.class, () -> confronto.sottrai(test));
        }

        {   // sub 0
            test = new Euro(1000);
            confronto = new  Euro(0);
            assertEquals(test.sottrai(confronto).getValore(), test.getValore());
        }

        {   // sub a negative
            test = new Euro(400);
            confronto = new Euro(-200);
            assertEquals(test.sottrai(confronto).getValore(), 60000);
        }

        {   // sub with cents
        test = new Euro(60);
        Euro sconto = new Euro (9,99);
            assertEquals(test.sottrai(sconto).getValore(), 5001);
        }

        {   // sub and compare
            test = new Euro(40.10);
            confronto = new Euro(30, 10);
            assertTrue(new Euro(10).ugualeA(test.sottrai(confronto)));
        }

    }

    @Test
    public void testStampa() {

        {   // print negative
            test = new Euro(-20);
            assertEquals(test.stampa(), "-20.0 euro");
        }

        {   // print 0
            test = new Euro(0);
            assertEquals(test.stampa(), "0.0 euro");
        }

        {   // print cents
        test = new Euro(23, 50);
        assertEquals(test.stampa(), "23.5 euro");
        }

    }

    @Test
    public void testUgualeA() {

        {   // compare to null
            test = null;
            confronto = new Euro(22);
            assertThrows(IllegalArgumentException.class, () -> confronto.ugualeA(test));
        }

        {   // compare to 0
            test = new Euro(0, 20);
            confronto = new Euro(0);
            assertFalse(confronto.ugualeA(test));
        }

        {   //compare negative
            test = new Euro(-42);
            confronto = new Euro(-42, 0);
            assertTrue(test.ugualeA(confronto));
        }

        {   // compare with cents
            confronto = new Euro(1.20);
            test = new Euro(1, 20);
            assertTrue(confronto.ugualeA(test));
        }

    }

}
