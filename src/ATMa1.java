
/// ATM

import java.util.Scanner;

public class ATMa1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.0;
        double withdrawAmount, depositAmount;

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("You have withdrawn $%.2f. New balance: $%.2f%n", withdrawAmount, balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.printf("You have deposited $%.2f. New balance: $%.2f%n", depositAmount, balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


    }
}