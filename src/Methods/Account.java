package Methods;

import java.util.HashMap;
import java.util.Random;

public class Account {
    private String FirstName;
    private String LastName;
    private String PassWord;



    public Account(String FirstName,String LastName,String PassWord){
        this.FirstName =FirstName;
        this.LastName = LastName;
        this.PassWord= PassWord;

    }


    public HashMap<String,String> getNewAccount(){
        String Balance = "0.00";
        String AccNumber = "";
        Random random = new Random();

        for (int count = 0; count < 10; count++) {
            int randomInt = random.nextInt(10);
            String singleNum = String.valueOf(randomInt);
            AccNumber += singleNum;
        }

        HashMap <String,String> details = new HashMap<>();
        details.put("First_Name",this.FirstName);
        details.put("Last_Name",this.LastName);
        details.put("Password",this.PassWord);
        details.put("Account_Number",AccNumber);
        details.put("Balance",Balance);


        return details;
    }

    public static HashMap<String,String> deposit(HashMap<String,String> details,double amount){
        String number = details.get("Balance");
        double addBalance = Double.valueOf(number);
        addBalance += amount;
        String backToLetter = String.valueOf(addBalance);
        details.put("Balance",backToLetter);
        return details;
    }

    public static boolean withdrawerConfirmation(HashMap<String,String> details,double amount){
        String number = details.get("Balance");
        double addBalance = Double.valueOf(number);
        if(amount>addBalance){
            return false;
        }else {
            return true;
        }

    }


    public static HashMap<String,String> withdrawer(HashMap<String,String> details,double amount){
        String number = details.get("Balance");
        double addBalance = Double.valueOf(number);
        addBalance -= amount;
        String backToLetter = String.valueOf(addBalance);
        details.put("Balance",backToLetter);
        return details;
    }

    public static String getBalance(HashMap<String,String> details){
        return details.get("Balance");
    }

    public static HashMap<String,String> changePin(HashMap<String,String> details,String newPin){

        details.put("Password",newPin);
        return details;
    }


    public static String getAccNumber(HashMap<String,String> details){
        return details.get("Account_Number");
    }
}
