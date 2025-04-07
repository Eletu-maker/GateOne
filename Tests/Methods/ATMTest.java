package Methods;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {

    @Test
    public void testAddAcount(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";

        ATM atm = new ATM();

        ArrayList<HashMap<String,String>> accounts = atm.addAccount(firstName, lastName, password);
        HashMap<String,String> account = accounts.get(0);



        assertEquals(firstName, account.get("First_Name"));
        assertEquals(lastName, account.get("Last_Name"));
        assertEquals(password, account.get("Password"));
        assertEquals("0.00", account.get("Balance"));

        String accNum =  account.get("Account_Number");



        assertEquals(10, accNum.length());
        assertTrue(accNum.matches("\\d{10}"));
    }


    @Test
    public void testGetAccNum(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);

        String result = ATM.getAccountNumber(firstName, lastName, password);
        assertEquals(10, result.length());
        assertTrue(result.matches("\\d{10}"));


    }

    @Test
    public void testGetAcc(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";

        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);



        assertTrue(atm.getAccount(firstName, lastName, password));
        assertFalse(atm.getAccount("usnam", lastName, password));
    }




    @Test
    public void testgetDeposit(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        double amount = 1000.0;
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        atm.getAccount(firstName, lastName, password);
        assertEquals("Successful, your current balance is 1000.0",atm.getDeposit(firstName, lastName, password,amount));
    }



    @Test
    public void getWithdrawer(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        double amount = 1000.0;
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        atm.getAccount(firstName, lastName, password);
        assertEquals("you dont have up to 1000.0 in your account",atm.getWithdrawer(firstName, lastName, password,amount));
    }



    @Test
    public void getWithdrawerII(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        double amount = 1000.0;
        double amount1 = 500.0;
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        atm.getAccount(firstName, lastName, password);
        atm.getDeposit(firstName, lastName, password,amount);
        assertEquals("Successful, your current balance is 500.0",atm.getWithdrawer(firstName, lastName, password,amount1));
    }


    @Test
    public void getBalance(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        double amount = 1000.0;
        double amount1 = 500.0;
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        atm.getAccount(firstName, lastName, password);
        atm.getDeposit(firstName, lastName, password,amount);
        atm.getWithdrawer(firstName, lastName, password,amount1);
        assertEquals("your current balance is 500.0",atm.Balance(firstName, lastName, password));
    }

    @Test
    public void changePin(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        String newPassword = "1111";
        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        atm.getAccount(firstName, lastName, password);
        assertEquals("your pin code has being successfully change.",atm.ChangePin(firstName, lastName, password,newPassword));
    }


    @Test
    public void testAccNumber(){
        String firstName = "suya";
        String lastName = "eric";
        String password = "1224";

        ATM atm = new ATM();
        atm.addAccount(firstName, lastName, password);
        String accNum = atm.getAccountNumber(firstName, lastName, password);
        assertEquals(10, accNum.length());
        assertTrue(accNum.matches("\\d{10}"));

    }


    @Test
    public void tranferMethod(){
        String firstName = "usman";
        String lastName = "eletu";
        String password = "1234";
        double amount = 1000.0;
        String recieverfirstName ="divie";
        String recieverlastName = "eletu";
        String recieverpassword = "1111";

        double amountTransfer = 100.0;


        ATM atm = new ATM();

        atm.addAccount(firstName, lastName, password);
        atm.addAccount(recieverfirstName,recieverlastName,recieverpassword);


        String accNum =atm.getACCnumber(recieverfirstName,recieverlastName,recieverpassword);


        atm.getDeposit(firstName, lastName, password, amount);

        assertEquals("Transaction was successful",
                ATM.transfer(firstName,lastName,password,recieverfirstName,amountTransfer,recieverlastName,accNum));
    }

}