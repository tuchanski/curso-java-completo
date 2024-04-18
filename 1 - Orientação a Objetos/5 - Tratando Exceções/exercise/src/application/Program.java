package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try {

            System.out.println("- Account data -");
            System.out.print("Number: ");
            int number = input.nextInt();
            System.out.print("Holder: ");
            input.nextLine();
            String holder = input.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = input.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = input.nextDouble();
            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("Enter an amount to withdraw: ");
            double amountToWithdraw = input.nextDouble();
            account.withdraw(amountToWithdraw);

            System.out.println();
            System.out.printf("New balance: %.2f", account.getBalance());
            input.close();
        }

        catch(DomainException e){
            System.out.println(e.getMessage());
        }

        catch(Exception e){
            System.out.println("Unexpected error");
        }

    }
}
