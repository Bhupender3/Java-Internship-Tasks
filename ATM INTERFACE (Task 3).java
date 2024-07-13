import java.util.Scanner;

class bankaccount {
    private double balance;

    public bankaccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Your current balance is: $" + balance);
        } else {
            System.out.println("Invalid withdraw amount. Please enter a positive amount.");
        }
    }
}

class ATM {
    private bankaccount account;

    public ATM(bankaccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option from the menu.");
            }
        }
        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getbalance());
    }

    private void deposit(double amount) {
        account.deposit(amount);
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        bankaccount account = new bankaccount(500); // Initial balance is $500
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
