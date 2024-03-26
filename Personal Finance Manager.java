import java.util.Scanner;

public class PersonalFinanceManager {
    private double balance;

    public PersonalFinanceManager(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        PersonalFinanceManager manager = new PersonalFinanceManager(initialBalance);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            double amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    amount = scanner.nextDouble();
                    manager.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    amount = scanner.nextDouble();
                    manager.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + manager.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
