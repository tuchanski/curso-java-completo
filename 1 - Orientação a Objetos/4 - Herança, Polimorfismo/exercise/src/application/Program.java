package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main (String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);

        System.out.print("Choose the number of products to be registered: ");
        int numberOfProducts = input.nextInt();

        List<Product> productList = new ArrayList<>();

        for(int i = 0; i < numberOfProducts; i++){
            System.out.println("\n- Registering Product #" + (i + 1) + " -");

            System.out.print("Enter a name: ");
            input.nextLine();
            String name = input.nextLine();

            System.out.print("Enter a price: ");
            double price = input.nextDouble();

            System.out.println("Type of products:\n[1] - Regular Product\n[2] - Used Product\n[3] - Imported Product");
            System.out.print("Choose here: ");
            int typeOfProduct = input.nextInt();
            while (typeOfProduct != 1 && typeOfProduct != 2 && typeOfProduct != 3){
                System.out.print("Invalid value. Choose here: ");
                typeOfProduct = input.nextInt();
            }
            switch (typeOfProduct){
                case 1:
                    Product product = new Product(name, price);
                    productList.add(product);
                    System.out.println("- Regular product has been added to the list!");
                    break;

                case 2:
                    System.out.print("Enter a manufacture date: ");
                    Date manufactureDate = sdf.parse(input.next());
                    UsedProduct usedProduct = new UsedProduct(name, price, manufactureDate);
                    productList.add(usedProduct);
                    System.out.println("- Used product has been added to the list!");
                    break;

                case 3:
                    System.out.print("Enter customs fee: ");
                    double customsFee = input.nextDouble();
                    ImportedProduct importedProduct = new ImportedProduct(name, price, customsFee);
                    productList.add(importedProduct);
                    System.out.println("- Imported product has been added to the list!");
                    break;
            }
        }
        System.out.println();
        for(Product product : productList){
            System.out.println(product.priceTag());
        }

        input.close();
    }

}
