package tests.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Database.Account;

public class AccountTest {

    Account test = null;

    @Test
    public void testValidatePIN(){

        {   // test true
            test = new Account(0, 98765, 0, 0);
            assertTrue(test.validatePIN(98765));
        }

        {   // test false
            test = new Account(0, 98765, 0, 0);
            assertFalse(test.validatePIN(12345));
        }
    }

    @Test
    public void testGetAvailableBalance(){

    }
    
    @Test
    public void testGetTotalBalance(){
        
    }

    @Test
    public void testCredit(){

    }

    @Test
    public void testDebit(){

    }

    @Test
    public void testGetAccountNumber(){

        {   // test true
            test = new Account(0, 0, 0, 0);
            assertEquals(test.getAccountNumber(), 0);
        }

        /*{   // test null
            test = new Account(1000, 0, 0, 0);
            assertEquals(test.getAccountNumber(), null);
        }*/
    }
    
}
