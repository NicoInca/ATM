package tests.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Database.BankDatabase;

public class BankDatabaseTest {

    BankDatabase database = new BankDatabase();

    @Test
    public void testAuthenticateUser(){
        
        {   // approved
            assertTrue(database.authenticateUser(12345, 54321));
        }

        {   // not exists
            assertFalse(database.authenticateUser(14725, 36925));
        }

        {   // wrong PIN
            assertFalse(database.authenticateUser(98765, 12345));
        }
    }

    @Test
    public void testGetAvailableBalance(){

        {// Test 1: testing first sample account balance
            assertEquals(database.getAvailableBalance(12345).getValore(), 100000);
        }
        {// Test 2: testing secomd sample account
            assertEquals(database.getAvailableBalance(98765).getValore(), 20000);
        }

    }

    @Test
    public void testGetTotalBalance(){

        {// Test 1: test first sample account
            assertEquals(database.getTotalBalance(12345).getValore(), 120000);
        }
        {// Test 2: test second sample account
            assertEquals(database.getTotalBalance(98765).getValore(), 20000);
        }
    }

    @Test
    public void testCredit(){

        {// Test 1
            database.credit(12345, 100.0);
            assertEquals(database.getTotalBalance(12345).getValore(), 130000);
        }
        {// Test2
            database.credit(98765, 1000.);
            assertEquals(database.getTotalBalance(98765).getValore(), 120000);
        }

    }

    @Test
    public void testDebit(){

        {
            
        }

    }
    
}
