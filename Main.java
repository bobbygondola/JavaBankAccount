
//SCANNER import for user input
import java.util.Scanner;

//MAIN METHOD
public class Main {
    // PUBLIC BANK ACCOUNT DEMO STARTER
    public static BankAccount newAccount = new BankAccount("Demo", "Demo", "33ig56d2");

    // MAIN METHOD
    public static void main(String[] args) {
        onboarding();
        welcome();
    }

    // DISPLAYBANNER method, called before and after the user makes a selection.
    public static void displayBanner() {
        System.out.println();
        System.out.println();
        System.out.println("MENU SELECTION");
        System.out.println();
        System.out.println("[1] - Create New Account");
        System.out.println("[2] - Deposit an Amount");
        System.out.println("[3] - Withdraw an Amount");
        System.out.println("[4] - Check Balance");
        System.out.println("[5] - Exit");
    }

    // NEWACCOUNTBANNER method, called after the user creates a new bank account,
    // displays their name, ID and a new starter balance message.
    public static void newAccountBanner() {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to your new account," + " " + newAccount.fName + " " + newAccount.lName);
        System.out.println();
        System.out.println("Your Account Number is:" + " " + "[" + newAccount.id + "]");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("IMPORTANT: New members recieve a $1,000 bonus! Check your balance using the Menu below!");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("New Member - MENU SELECTION");
        System.out.println();
        System.out.println("[1] - Create New Account");
        System.out.println("[2] - Deposit an Amount");
        System.out.println("[3] - Withdraw an Amount");
        System.out.println("[4] - Check Balance");
        System.out.println("[5] - Exit");
    }

    // ONBOARDING method, method called before WELCOME to introduce the use to the
    // system, advises them to create a new account.
    public static void onboarding() {
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "Welcome to the Bank! Please explore our DEMO to test how amazing our User Experience can be!");
        System.out.println(
                "DISCLAIMER: The Demo account is for User Experience exploring only. Create an account to officially join.");
        System.out.println(
                "When you're ready, please CREATE AN ACCOUNT using the menu options to take part in our amazing Banking system!");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // WELCOME method, holds the main funcitonality of the program. Calls
    // DISPLAYBANNER and then prompts a selection from the Menu.
    public static void welcome() {
        Scanner input = new Scanner(System.in);
        int selection = 0;

        displayBanner();

        // While the users Menu selection isnt "5" or "Quit", the program will run and
        // continue to prompt the user.
        while (selection != 5) {
            System.out.println("-----------------------------------");
            System.out.println("Make a selection from the Menu");
            System.out.println("-----------------------------------");
            selection = input.nextInt();
            System.out.println();

            // Switch statement instead of an if-else statement to query through and find
            // the correct methods to run/nput to collect.
            switch (selection) {

                // NEWACCOUNT switch 1, collects data first. Creates a new BankAccount OBJ.
                // Calls the NEWACCOUNTBANNER method.
                case 1:
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println(
                            "Welcome to account creaton! All new members will recieve a $1,000 bonus for signing up!");
                    System.out.println("Please complete the following steps below.");
                    System.out.println();
                    System.out.println("Enter your First name: ");
                    input.nextLine();
                    String newName = input.nextLine();

                    System.out.println("Enter your Last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Create a Bank ID (Mix of Numbers and Characters): ");
                    String newID = input.nextLine();

                    BankAccount newerAccount = new BankAccount(newName, lastName, newID);
                    newAccount = newerAccount;
                    newAccount.setBalance(1000);

                    newAccountBanner();
                    break;

                // DEPOSIT switch 2, collects data and passes to the DEPOSIT method. Calls the
                // DISPLAYBANNER method.
                case 2:
                    System.out.println("-----------------------------------");
                    System.out.println("Enter an amount to Deposit:");
                    System.out.println("-----------------------------------");
                    int amount = input.nextInt();
                    newAccount.deposit(amount);
                    System.out.println();
                    displayBanner();
                    break;

                // WITHDRAW switch 3, collects data and passes to the DEPOSIT method. Calls the
                // DISPLAYBANNER method.
                case 3:
                    System.out.println("-----------------------------------");
                    System.out.println("Enter an amount to Withdraw:");
                    System.out.println("-----------------------------------");
                    newAccount.withdraw(input.nextInt());
                    System.out.println();
                    displayBanner();
                    break;

                // GETBALANCE switch 4, calls the GETBALANCE method with display message. Calls
                // the DISPLAYBANNER method.
                case 4:
                    System.out.println("-----------------------------------");
                    System.out.println("Checking Balance:");
                    System.out.println("-----------------------------------");
                    System.out.println("AVAILABLE BALANCE: " + newAccount.getBalance());
                    displayBanner();
                    break;

                default:
                    // System.out.println("Please enter a valid input");
                    break;
            }
        }
        // QUIT SELECTION, ends the while loop and prompts a message.
        System.out.println(
                "Are you sure you want to quit? Press [5] to confirm. Press any other NUMBER KEY to return to the Menu.");
        int ensure = input.nextInt();
        if (ensure != 5) {
            welcome();
        } else {
            System.out.println("Thank you for using the Bank!");
        }
    }
}

// BANKACCOUNT class
class BankAccount {

    // Fields or data
    String fName, lName, id;
    double balance = 0.00;

    // Constructor, not totally needed as I dont set a balance here for a new
    // account. Java creates a constructor but its nice to have to set up data.
    public BankAccount(String fiName, String laName, String newId) {
        fName = fiName;
        lName = laName;
        id = newId;
    }

    // SETBALANCE, sets the passed in starting value to balance. Called in the
    // NEWACCOUNT METHOD.
    public void setBalance(double start) {
        balance += start;
    }

    // GETBALANCE, returns the current balance of the BankAccoutn class OBJ. Called
    // in the CHECKBALANCE switch statement [4].
    public double getBalance() {
        return balance;
    }

    // DEPOSIT, adds the passed in amount value to balance. Called in the DEPOSIT
    // switch statement [2]. Checks for invalid data. Prompts a report and success
    // message.
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println();
            System.out.println("ERROR: Please enter a larger amount");
            System.out.println("TRANSACTION REPORT:");
            System.out.println("---------------------");
            System.out.println("REQUESTED DEPOSIT AMOUNT: " + amount);
            System.out.println("---------------------");
        } else {
            balance += amount;
            System.out.println("SUCCESS");
        }
    }

    // WITHDRAW, adds the passed in amount value to balance. Called in the DEPOSIT
    // switch statement [2]. Checks for invalid data. Prompts a report and success
    // message.
    public void withdraw(double amount) {
        if (balance < amount || amount <= 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println();
            System.out.println("ERROR: Your balance is too low");
            System.out.println();
            System.out.println("TRANSACTION REPORT:");
            System.out.println("---------------------");
            System.out.println("REQUESTED AMOUNT: " + amount);
            System.out.println("AVAILABLE AMOUNT: " + balance);
            System.out.println("---------------------");
        } else {
            balance -= amount;
            System.out.println("SUCCESS");
        }
    }
}