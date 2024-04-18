package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>(); // Ordena

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "40028922");

        cookies.remove("email");
        cookies.put("phone", "40021133");

        System.out.println("Cookies: ");
        for (String key : cookies.keySet()){
            System.out.println(key + ": " + cookies.get(key));
        }


    }

}
