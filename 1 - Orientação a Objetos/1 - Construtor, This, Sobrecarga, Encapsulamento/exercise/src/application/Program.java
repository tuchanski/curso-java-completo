package application;

import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);


        System.out.println("- OOP #1 Exercise -");
        System.out.print("Enter account ID: ");
        int accountID = input.nextInt();

        System.out.print("Enter account holder first name: ");
        String firstName = input.next().toUpperCase();
        System.out.print("Enter account holder surname: ");
        String surname = input.next().toUpperCase();
        String fullName = firstName + " " + surname;

        BankAccount bankAccount = new BankAccount(accountID, fullName);

        System.out.print("\n[y/n] - Is there an initial value to be deposited? ");
        String firstDepositValidation = input.next().toUpperCase();

        while(!firstDepositValidation.equals("Y") && (!firstDepositValidation.equals("N"))){
            System.out.print("[y/n] - Invalid input. Is there an initial value to be deposited? ");
            firstDepositValidation = input.next().toUpperCase();
        }

        if(firstDepositValidation.equals("Y")){
            System.out.print("\nInsert the value to be deposited: ");
            double depositedValue = input.nextDouble();
            bankAccount.deposit(depositedValue);
        }

        System.out.println("Account data: \n" + bankAccount);

        System.out.print("\nInsert a deposit value: ");
        double valueToBeDeposited = input.nextDouble();
        bankAccount.deposit(valueToBeDeposited);

        System.out.print("Updated data: \n" + bankAccount);

        System.out.print("\nEnter a withdraw value: ");
        double valueToBeWithdraw = input.nextDouble();
        bankAccount.withdraw(valueToBeWithdraw);

        System.out.println("Updated data: \n" + bankAccount);

    }
}
