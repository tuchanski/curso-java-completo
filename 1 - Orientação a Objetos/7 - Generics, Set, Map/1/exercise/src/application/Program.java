package application;

import java.util.Locale;
import java.util.Scanner;

import services.PrintService;

public class Program {

    public static void main(String[] args){

        // Primeira aplicacao de Generics - Parametrizar o tipo

        /*Deseja-se fazer um programa que leia uma quantidade N, e depois N números
        inteiros. Ao final, imprima esses números de forma organizada conforme
        exemplo. Em seguida, informar qual foi o primeiro valor informado*/

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        PrintService<Integer> printServiceInteger = new PrintService<>();

        System.out.print("Enter the quantity of elements: ");
        int quantity = input.nextInt();

        for (int i = 0; i < quantity; i++){
            System.out.printf("\n[%d] - Enter a number:  ", i);
            int numberToAdd = input.nextInt();
            printServiceInteger.addValue(numberToAdd);
        }

        System.out.println();
        printServiceInteger.print();
        System.out.println();
        System.out.println(printServiceInteger.first());

        input.close();

    }

}
