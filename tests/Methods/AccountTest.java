package Methods;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    public void testgetNewAcc(){
        Account acc = new Account("usman","eletu","1234");
        HashMap<String, String> accountDetails = acc.getNewAccount();
        assertEquals("usman",accountDetails.get("First_Name"));
        assertEquals("eletu",accountDetails.get("Last_Name"));
        assertEquals("1234",accountDetails.get("Password"));
        assertEquals("0.00",accountDetails.get("Balance"));


        String accNumber =  accountDetails.get("Account_Number");
        assertEquals(accNumber,accountDetails.get("Account_Number"));



    }

    @Test
    public void testDeposit(){

        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","0.00");

        HashMap<String,String> acc1 = new HashMap<>();
        acc1.put("First_Name","usman");
        acc1.put("Last_Name","eletu");
        acc1.put("Password","1234");
        acc1.put("Account_Number","1234567890");
        acc1.put("Balance","100.0");

        assertEquals(acc1,Account.deposit(acc,100));
    }


    @Test
    public void testwithdrawerConfirmation(){
        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","0.00");

        assertFalse(Account.withdrawerConfirmation(acc, 100));
    }




    @Test
    public void testwithdrawerConfirmationII(){
        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","1000.00");

        assertTrue(Account.withdrawerConfirmation(acc, 100));
    }



    @Test
    public void testwithdrawer(){

        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","1000.00");

        HashMap<String,String> acc1 = new HashMap<>();
        acc1.put("First_Name","usman");
        acc1.put("Last_Name","eletu");
        acc1.put("Password","1234");
        acc1.put("Account_Number","1234567890");
        acc1.put("Balance","100.0");

        assertEquals(acc1,Account.withdrawer(acc,900));
    }

    @Test
    public void testCheckBalance(){
        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","1000.00");

        assertEquals(acc.get("Balance"),Account.getBalance(acc));
    }

    @Test
    public void testChangePin(){
        HashMap<String,String> acc = new HashMap<>();
        acc.put("First_Name","usman");
        acc.put("Last_Name","eletu");
        acc.put("Password","1234");
        acc.put("Account_Number","1234567890");
        acc.put("Balance","1000.0");

        HashMap<String,String> acc1 = new HashMap<>();
        acc1.put("First_Name","usman");
        acc1.put("Last_Name","eletu");
        acc1.put("Password","1010");
        acc1.put("Account_Number","1234567890");
        acc1.put("Balance","1000.0");

        assertEquals(acc1,Account.changePin(acc,"1010"));
    }

    @Test
    public void testGetAccNumber(){
        Account acc = new Account("usman","eletu","1234");
        HashMap<String, String> accountDetails = acc.getNewAccount();
        String accNumber =  accountDetails.get("Account_Number");
        assertEquals(accNumber,Account.getAccNumber(accountDetails));
    }

}