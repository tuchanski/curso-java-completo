package application;

import java.util.Locale;
import java.util.Scanner;

import services.InterestService;
import services.USAInterestService;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = input.nextDouble();

        System.out.print("Months: ");
        int months = input.nextInt();

        InterestService is = new USAInterestService(1.0);
        double  payment =  is.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.println(String.format("%.2f", payment));


        input.close();

    }

}
