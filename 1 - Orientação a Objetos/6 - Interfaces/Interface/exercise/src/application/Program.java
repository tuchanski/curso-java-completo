package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("- Entre  os dados do contrato:");
        System.out.print("- Número: ");
        int number = input.nextInt();
        System.out.print("- Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(input.next(), dtf);
        System.out.print("- Valor do contrato: ");
        double totalValue = input.nextDouble();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("- Entre com o número de parcelas: ");
        int n = input.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);
        
        for (Installment installment : obj.getInstallments()){
            System.err.println(installment);
        }

        input.close();
    }
}
