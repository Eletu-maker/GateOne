package Methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

            System.out.print("Enter your choice: ");
            int option = entries.nextInt();

            while (option <= 0 || option > 4) {
                System.out.println("Unacceptable value: please enter option number.");
                System.out.print("Enter your choice: ");
                option = entries.nextInt();
            }
            switch (option) {
                case 1:
                    System.out.print("Enter your First name: ");
                    entries.nextLine();
                    String FirstName = entries.nextLine();

                    System.out.print("Enter your Last name: ");

                    String LastName = entries.nextLine();
                    System.out.print("Enter your Password: ");
                    String Password = entries.nextLine();
                    while (!Password.matches("\\d{4}")) {
                        System.out.print("Password must be 4 digist: ");
                        Password = entries.nextLine();

                    }

                    addAccount(FirstName,LastName,Password);
                    String accNumber =getAccountNumber(FirstName,LastName,Password);
                    System.out.println("here is your account Number:"+accNumber);


                    break;


                case 2:
                    System.out.print("Enter your First name: ");
                    entries.nextLine();
                    String Name1 = entries.nextLine();

                    System.out.print("Enter your Last name: ");

                    String Name2 = entries.nextLine();
                    System.out.print("Enter your Password: ");
                    String Pin = entries.nextLine();

                    boolean check = getAccount(Name1,Name2,Pin);
                    if (check){
                        System.out.println(getACCnumber(Name1,Name2,Pin));
                        System.out.println("""
                            
                            Enter what transaction you want to do 
                            
                            1. deposit.
                            2. withdraw.
                            3. transfer.
                            4. change pin.
                            5. check balance.
                            """);
                        System.out.print("Enter your choice: ");
                        int option2 = entries.nextInt();

                        while (option2 <= 0 || option2 > 5) {
                            System.out.println("Unacceptable value: please enter option number.");
                            System.out.print("Enter your choice: ");
                            option2 = entries.nextInt();
                        }

                        switch (option2){
                            case 1:
                                System.out.print("Enter amount:");
                                double amount = entries.nextDouble();
                                System.out.println(getDeposit(Name1,Name2,Pin,amount));

                                break;
                            case 2:
                                System.out.print("Enter amount:");
                                double amount1 = entries.nextDouble();
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
                                System.out.print("Enter amount: ");

                                double amountTransfer = entries.nextDouble();

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

    public static String transfer(String FirstName, String LastName, String PassWord,String ReciverName,double amount,
                                  String ReciverlastName, String AccountNumber) {
        for (HashMap<String, String> detail : AllAcc) {
            if (detail.get("First_Name").equals(FirstName)
                    && detail.get("Last_Name").equals(LastName)
                    && detail.get("Password").equals(PassWord)) {
                boolean check = Account.withdrawerConfirmation(detail, amount);
                if (check) {
                    Account.withdrawer(detail, amount);

                } else {
                    return "you dont have up to " + amount + " in your account";
                }
            }
        }

        for (HashMap<String, String> detail2 : AllAcc) {
            if (detail2.get("First_Name").equals(ReciverName)
                    && detail2.get("Last_Name").equals(ReciverlastName)
                    && detail2.get("Account_Number").equals(AccountNumber)) {
                Account.deposit(detail2, amount);
            } else {
                return "This account do not exist";
            }
        }
        return "Transaction was successful";
    }







}
