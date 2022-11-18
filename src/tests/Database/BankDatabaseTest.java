package tests.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Database.Account;
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
    
}
