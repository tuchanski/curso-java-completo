package application;

import entities.Client;

public class Program {
    public static void main(String[] args){

        Client client1 = new Client("Guilherme Tuchanski", "guiminecraft@gmail.com");
        Client client2=  new  Client("Jotaro Kujo", "jojosbizarreadventure@gmail.com");
        Client client3 = new Client("Guilherme Tuchanski", "guiminecraft@gmail.com");

        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());
        System.out.println(client3.hashCode());
        System.out.println(client1.equals(client2));
        System.out.println(client1.equals(client3));
        System.out.println(client1 == client3); // Falso pois dessa forma compara a posição na memória Heap

    }

}
