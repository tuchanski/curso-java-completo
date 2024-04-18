package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("- Entre o caminho do arquivo: ");
        String path = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);
                
                if (votes.containsKey(name)){
                    int votesAtTheMoment = votes.get(name);
                    votes.put(name, count + votesAtTheMoment);
                }

                else{
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
            }

        }

        catch (IOException e){
            System.out.println("- Erro: " + e.getMessage());
        }

        input.close();
        
    }

}
