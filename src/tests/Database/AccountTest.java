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

        {// Test 1
            test = new Account(0, 98765, 1000.0, 1000.0);
            assertEquals(test.getAvailableBalance().getValore(), 100000.0, 0);
        }
        {// Test 2
            test = new Account(0, 23456, -1.0, 325.8);
            assertEquals(test.getAvailableBalance().getValore(), -100, 0);
        }

    }
    
    @Test
    public void testGetTotalBalance(){
        
        {// Test 1
            test = new Account(0, 98765, 1000.0, 1000.0);
            assertEquals(test.getTotalBalance().getValore(), 100000.0, 0);
        }
        {// Test 2
            test = new Account(0, 23456, 371.1, -196.8);
            assertEquals(test.getTotalBalance().getValore(), -196.8*100, 0);
        }

    }

    @Test
    public void testCredit(){

        {// Test 1
            double starting_balance = 200.0;
            double difference = 25.1;
            test = new Account(0, 12345, starting_balance, starting_balance);
            test.credit(difference);
            assertEquals(test.getTotalBalance().getValore(), (starting_balance+difference)*100, 0);
        }
        {// Test 2
            double starting_balance = -362.0;
            double difference = 765.1;
            test = new Account(0, 12345, starting_balance, starting_balance);
            test.credit(difference);
            assertEquals(test.getTotalBalance().getValore(), (starting_balance+difference)*100, 0);
        }

    }

    @Test
    public void testDebit(){
        
        {// Test 1
            double starting_balance = 742.0;
            double difference = 45.8;
            test = new Account(0, 12345, starting_balance, starting_balance);
            test.debit(difference);
            assertEquals(test.getTotalBalance().getValore(), (starting_balance-difference)*100, 0);
            assertEquals(test.getAvailableBalance().getValore(), (starting_balance-difference)*100, 0);
        }
        {// Test 2
            double starting_balance = -28521.72;
            double difference = 378.21;
            test = new Account(0, 12345, starting_balance, starting_balance);
            test.debit(difference);
            assertEquals(test.getTotalBalance().getValore(), (starting_balance-difference)*100, 0);
            assertEquals(test.getAvailableBalance().getValore(), (starting_balance-difference)*100, 0);
        }

    }

    @Test
    public void testGetAccountNumber(){

        {   // test true
            test = new Account(0, 0, 0, 0);
            assertEquals(test.getAccountNumber(), 0);
        }
    }
    
}
