package application;

import java.util.HashMap;
import java.util.Map;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        Map<Product, Integer> stock = new HashMap<>();

        Product p1 = new Product("Geforce GTX 1070", 750.00);
        Product p2 = new Product("Ryzen 5 2600", 300.00);
        Product p3 = new Product("XPG Core Reactor 750w", 850.00);

        stock.put(p1, 100);
        stock.put(p2, 200);
        stock.put(p3, 300);

        Product ps = new Product("Geforce GTX 1070", 750.00);

        System.out.println("Contains ps key: " + stock.containsKey(ps)); // Falso se equals e compareTo nao estao implementados - comparacao feita por ponteiros.
        
    }

}
