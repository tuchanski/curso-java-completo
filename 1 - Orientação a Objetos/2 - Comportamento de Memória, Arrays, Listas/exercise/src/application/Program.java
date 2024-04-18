package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        List<Integer> registeredIDs = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        System.out.print("- Enter the number of employees to be registered: ");
        int numberOfEmployees =  input.nextInt();

        for(int i = 0; i < numberOfEmployees; i++){
            System.out.println("Creating Employee #" + (i + 1));
            System.out.print("- Enter an ID: ");
            int id = input.nextInt();

            while (registeredIDs.contains(id)){
                System.out.print("- ID already registered. Try again: ");
                id = input.nextInt();
            }
            registeredIDs.add(id);

            System.out.print("- Enter a name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("- Enter a salary: ");
            double salary = input.nextDouble();

            Employee employee = new Employee(id, name, salary);
            employees.add(employee);

        }

        System.out.println("Data: " + employees);

        System.out.print("- Select an ID to increase salary: ");
        int id = input.nextInt();

        while (!registeredIDs.contains(id)){
            System.out.print("Invalid ID. Try again: ");
            id = input.nextInt();
        }

        for (Employee employee : employees){
            if(employee.getId() == id){
                System.out.println("ID FOUND - " + employee.getId());
                System.out.print("- Enter a percentage value to increase selected employee salary: ");
                double percentage = input.nextInt();
                employee.increaseSalary(percentage/100);
                System.out.println("Salary: " + employee.getSalary());
            }
        }

        System.out.println("Updated data: " + employees);

        input.close();

    }
}
