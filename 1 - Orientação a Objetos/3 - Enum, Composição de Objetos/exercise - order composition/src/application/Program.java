package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);

        System.out.println("- Client Data -");
        System.out.print("Name: ");
        String name = input.nextLine().toUpperCase();
        System.out.print("E-mail: ");
        String email = input.nextLine().toLowerCase();
        System.out.print("[dd/mm/yyyy] - Birth date: ");
        String dateToConversion = input.nextLine();
        Date birthDate = sdf.parse(dateToConversion);

        Client client = new Client(name, email, birthDate);

        System.out.println("- Order Data -");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next().toUpperCase());
        Order order = new Order(new Date(), status, client);

        System.out.print("Insert the number of items for this order: ");
        int itemsQuantity = input.nextInt();

        for(int i = 0; i < itemsQuantity; i++){
            System.out.println("- Registering Product #" + (i+1) + " -");
            System.out.print("Name: ");
            input.nextLine();
            String productName = input.nextLine().toUpperCase();
            System.out.print("Price: ");
            double productPrice = input.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = input.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem thisOne = new OrderItem(productQuantity, productPrice, product);
            order.addItem(thisOne);
        }

        System.out.println();
        System.out.println("- Order Summary -");
        System.out.println(order);
        input.close();
    }
}
