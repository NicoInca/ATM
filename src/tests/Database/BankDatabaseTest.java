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
            assertEquals(database.getAvailableBalance(12345).getValore(), 100000, 0);
        }
        {// Test 2: testing secomd sample account
            assertEquals(database.getAvailableBalance(98765).getValore(), 20000, 0);
        }

    }

    @Test
    public void testGetTotalBalance(){

    }

    @Test
    public void testCredit(){

    }

    @Test
    public void testDebit(){

        {   // test 1
            database.debit(12345, 1000);
            assertEquals(database.getAvailableBalance(12345).getValore(), 0);
        }

        {   // test 2
            database.debit(98765, 1000);
            assertEquals(database.getAvailableBalance(98765).getValore(), -80000); 
        }

    }
    
}
