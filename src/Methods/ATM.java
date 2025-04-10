package Methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ATM {
    static Scanner entries = new Scanner(System.in);

    static boolean repeat = true;
    public static ArrayList<HashMap<String, String>> AllAcc = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("welcome to Banke Bank");

        while (repeat) {
            System.out.println("""
                    
                    Enter your choice of option
                    1. Create an account.
                    2. access your account.
                    3. Close account.
                    4. Exist.
                    
                    
                    """);

            int option = 0;
            boolean valid = false;

            while (!valid) {
                try {
                    System.out.print("Enter your choice: ");
                    option = entries.nextInt();

                    if (option < 1 || option > 4) {
                        System.out.println("Unacceptable value: please enter option number between 1 and 5.");
                    } else {
                        valid = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: please enter a number.");
                    entries.next();
                }
            }

            switch (option) {
                case 1:
                    System.out.print("Enter your First name: ");
                    entries.nextLine();
                    String FirstName = entries.nextLine();
                    while(FirstName.isEmpty()){
                        System.out.println("Enter your details please ");
                        FirstName = entries.nextLine();
                    }
                    System.out.print("Enter your Last name: ");

                    String LastName = entries.nextLine();
                    while(LastName.isEmpty()){
                        System.out.println("Enter your details please ");
                        LastName = entries.nextLine();
                    }
                    System.out.print("Enter your Password: ");
                    String Password = entries.nextLine();
                    while (!Password.matches("\\d{4}")) {
                        System.out.print("Password must be 4 digist: ");
                        Password = entries.nextLine();

                    }
                        boolean checking = checkaddAccount(FirstName,LastName,Password);
                    if (checking) {
                        addAccount(FirstName, LastName, Password);
                        String accNumber = getAccountNumber(FirstName, LastName, Password);
                        System.out.println("here is your account Number:" + accNumber);
                    }else {
                        System.out.println("Account already exist");
                    }

                    break;


                case 2:
                    System.out.print("Enter your First name: ");
                    entries.nextLine();
                    String Name1 = entries.nextLine();

                    System.out.print("Enter your Last name: ");

                    String Name2 = entries.nextLine();
                    System.out.print("Enter your Password: ");
                    String Pin = entries.nextLine();
                    while (!Pin.matches("\\d{4}")) {
                        System.out.print("Password must be 4 digist: ");
                        Pin = entries.nextLine();

                    }

                    boolean check = getAccount(Name1,Name2,Pin);
                    if (check){
                       // System.out.println(getACCnumber(Name1,Name2,Pin));
                        System.out.println("""
                            
                            Enter what transaction you want to do. 
                            
                            1. deposit.
                            2. withdraw.
                            3. transfer.
                            4. change pin.
                            5. check balance.
                            """);
                        System.out.print("Enter your choice: ");
                        int option2 = 0;

                         valid = false;
                        while (!valid) {
                            try {
                                System.out.print("Enter your choice: ");
                                option2 = entries.nextInt();

                                if (option2 < 1 || option2 > 5) {
                                    System.out.println("Unacceptable value: please enter option number between 1 and 5.");
                                } else {
                                    valid = true;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input: please enter a number.");
                                entries.next();
                            }
                        }

                        switch (option2){
                            case 1:

                                double amount =0 ;
                                valid = false;
                                while (!valid) {
                                    try {
                                        System.out.print("Enter amount:");
                                        amount = entries.nextDouble();

                                        if (amount < 0 ) {
                                            System.out.println("no negative number");
                                        } else {
                                            valid = true;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input: please enter a number.");
                                        entries.next();
                                    }
                                }
                                System.out.println(getDeposit(Name1,Name2,Pin,amount));

                                break;
                            case 2:

                                double amount1 = 0;

                                valid = false;
                                while (!valid) {
                                    try {
                                        System.out.print("Enter amount:");
                                        amount1 = entries.nextDouble();

                                        if (amount1 < 0 ) {
                                            System.out.println("no negative number");
                                        } else {
                                            valid = true;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input: please enter a number.");
                                        entries.next();
                                    }
                                }
                                System.out.println(getWithdrawer(Name1,Name2,Pin,amount1));

                                break;
                            case 3:
                                System.out.print("Enter reciever first name: ");
                                entries.nextLine();
                                String RecieverName = entries.nextLine();
                                System.out.print("Enter reciever last name: ");
                                String RecieverName1 = entries.nextLine();
                                System.out.print("Enter reciever account number: ");

                                String AccountNumber = entries.nextLine();



                                double amountTransfer = 0;

                                valid = false;
                                while (!valid) {
                                    try {
                                        System.out.print("Enter amount:");
                                        amountTransfer = entries.nextDouble();

                                        if (amountTransfer < 0 ) {
                                            System.out.println("no negative number");
                                        } else {
                                            valid = true;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input: please enter a number.");
                                        entries.next();
                                    }
                                }

                                System.out.println(transfer(Name1,Name2,Pin,RecieverName,amountTransfer,RecieverName1,AccountNumber));



                                break;
                            case 4:
                                System.out.print("Enter your new pass code:");
                                entries.nextLine();
                                String newPin = entries.nextLine();
                                while (!newPin.matches("\\d{4}")) {
                                    System.out.print("Password must be 4 digist: ");
                                    newPin = entries.nextLine();

                                }
                                System.out.println(ChangePin(Name1,Name2,Pin,newPin));
                                break;
                            case 5:
                                System.out.println(Balance(Name1,Name2,Pin));
                                break;
                        }
                    }else System.out.println("such Account do not exist in our blank");

                    break;


                case 3:
                    System.out.print("Enter your First name: ");
                    entries.nextLine();
                    String Name20 = entries.nextLine();

                    System.out.print("Enter your Last name: ");

                    String Name2i = entries.nextLine();
                    System.out.print("Enter your Password: ");
                    String Pin1 = entries.nextLine();

                    System.out.println(delAccount(Name20,Name2i,Pin1));
                    break;
                case 4:
                    repeat = false;
                    break;


                default:
                    break;

            }




        }
    }
    public static ArrayList<HashMap<String, String>> addAccount(String FirstName, String LastName, String PassWord){
        Account acc = new Account(FirstName,LastName,PassWord);
        AllAcc.add(acc.getNewAccount());

        return  AllAcc;

    }
    public static boolean checkaddAccount(String FirstName, String LastName, String PassWord){
        boolean check = true;
        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                check = false;
            }
        }
        return check;
    }

    public static String getAccountNumber(String FirstName, String LastName, String PassWord){
        String acc = "";
        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                acc = detail.get("Account_Number");
            }
        }

        return acc;
    }


    public static boolean getAccount(String FirstName, String LastName, String PassWord){
        boolean check = false;
        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                check = true;
            }
        }
        return check;
    }


    public static String getDeposit(String FirstName, String LastName, String PassWord,double amount){
        String bal ="";

        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                HashMap<String,String> reuslt= Account.deposit(detail,amount);
                bal = reuslt.get("Balance");

            }
        }

        return "Successful, your current balance is "+ bal;
    }


    public static String getWithdrawer(String FirstName, String LastName, String PassWord,double amount){
        String bal ="";

        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                boolean check= Account.withdrawerConfirmation(detail,amount);
                if(check){
                    HashMap<String,String> result =  Account.withdrawer(detail,amount);
                    bal = result.get("Balance");
                }else{
                    return "you dont have up to "+amount+" in your account";
                }

            }
        }

        return "Successful, your current balance is "+ bal;
    }

    public static String Balance(String FirstName, String LastName, String PassWord){
        String bal ="";

        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                bal = Account.getBalance(detail);

            }
        }

        return "your current balance is "+ bal;
    }
    public static String getACCnumber(String FirstName, String LastName, String PassWord){
        String accnumber = "";
        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                accnumber=  Account.getAccNumber(detail);

            }
        }
        return accnumber;
    }

    public static String ChangePin(String FirstName, String LastName, String PassWord,String newPin){
        for(HashMap<String,String> detail:AllAcc){
            if(detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)){
                Account.changePin(detail,newPin);

            }
        }
        return "your pin code has being successfully change.";
    }

    public static String transfer(String FirstName, String LastName, String PassWord, String ReciverName,
                                  double amount, String ReciverlastName, String AccountNumber) {
        HashMap<String, String> sender = null;
        HashMap<String, String> receiver = null;

        for (HashMap<String, String> detail : AllAcc) {
            if (detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)) {
                sender = detail;
            }
        }

        for (HashMap<String, String> detail : AllAcc) {
            if (detail.get("First_Name").equals(ReciverName)
                    && detail.get("Last_Name").equals(ReciverlastName)
                    && detail.get("Account_Number").equals(AccountNumber)) {
                receiver = detail;
            }
        }

        if (sender == null) {
            return "Sender account not found";
        }

        if (receiver == null) {
            return "Receiver account not found";
        }

        if (!Account.withdrawerConfirmation(sender, amount)) {
            return "you dont have up to " + amount + " in your account";
        }

        Account.withdrawer(sender, amount);
        Account.deposit(receiver, amount);

        return "Transaction was successful";
    }


    public static String delAccount(String FirstName, String LastName, String PassWord){
        int numb =0;
        String response = "";
        for(int count = 0; count< AllAcc.size();count++){
       if(AllAcc.get(count).get("First_Name").equals(FirstName) && AllAcc.get(count).get("Last_Name").equals(LastName)
               &&  AllAcc.get(count).get("Password").equals(PassWord)){
           numb++;
            AllAcc.remove(count);
       }
       }
        if(numb ==0){
            response = "such account do not exist";
        }else {
            response = "account has being close";
        }
        return response;
    }




}
