import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Cannot withdraw.");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}

// Class representing an ATM machine
class ATM {
    private BankAccount account;

    // Constructor to associate the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // User interface for ATM operations
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- ATM Interface ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Check balance
                    System.out.println("Your current balance: $" + account.checkBalance());
                    break;
                case 2:
                    // Deposit money
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    // Withdraw money
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (option != 4);

        scanner.close();
    }
}

// Main class to run the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize the user's bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance $1000

        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(userAccount);

        // Show the ATM interface to the user
        atm.showMenu();
    }
}
