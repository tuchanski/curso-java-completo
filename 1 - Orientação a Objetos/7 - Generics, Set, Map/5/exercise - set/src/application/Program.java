package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

    public static void main(String[] args) {

        Set<String> set =  new HashSet<>(); // Hashset -> implementação da interface Set mais rápida, não garante a mesma ordem
        //Set<String> set = new TreeSet<>(); // TreeSet -> implementação da  interface Set que é mais lenta porém  garante a ordem com compareTo
       // Set<String> set = new LinkedHashSet<>() //  LinkedHashSet  -> Mantém a ordem de  inserção dos elementos

        set.add("Geforce RTX 4060");
        set.add("Ryzen 7 3700x");
        set.add("Ram 32GB");

        //set.removeIf(x -> x.length() >= 3); // Permite predicado
        //set.remove("Ram 32GB");

        System.out.println(set.contains("Geforce RTX 4060"));

        for(String o : set){
            System.out.println(o);
        }

        System.out.println("***********");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 6, 7, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // uniao

        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        // intersecçao

        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        // diferença

        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);

    }
}