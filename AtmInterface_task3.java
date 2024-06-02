import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            throw new InsufficientBalanceException("Insufficient funds for this withdrawal.");
        }
    }
}

public class AtmInterface_task3 {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Interface");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        account.withdraw(withdrawAmount);
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depositAmount);
                    break;
                case "3":
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}
