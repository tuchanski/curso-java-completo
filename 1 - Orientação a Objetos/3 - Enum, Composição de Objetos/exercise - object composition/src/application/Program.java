package application;

import entities.Department;
import entities.Employee;
import entities.HourContract;
import entities.enums.EmployeeLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = input.nextLine();
        System.out.println("- Enter employee data -");
        System.out.print("Name: ");
        String employeeName = input.nextLine();
        System.out.print("Level: ");
        String employeeLevel = input.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = input.nextDouble();

        Employee employee = new Employee(employeeName, EmployeeLevel.valueOf(employeeLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts will belong to this employee? ");
        int numberOfContracts = input.nextInt();

        for(int i = 0; i < numberOfContracts; i++){
            System.out.print("- CONTRACT #" + (i + 1) + " DATA -\n");
            System.out.print("Date [DD/MM/YYYY]: ");
            Date contractDate = sdf.parse(input.next());
            System.out.print("Value [hours]: ");
            double valuePerHour = input.nextDouble();
            System.out.print("Duration [hours]: ");
            int hours = input.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            employee.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income [MM/YYYY]: ");
        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + employee.getName());
        System.out.println("Department: " + employee.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", employee.income(month, year)));

        input.close();
    }
}
