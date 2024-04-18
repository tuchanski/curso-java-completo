package entities;

import entities.enums.EmployeeLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Employee {

    private String name;
    private EmployeeLevel level;
    private double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Employee(){}

    public Employee(String name, EmployeeLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public void setLevel(EmployeeLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar calendar = Calendar.getInstance();
        for(HourContract contract : contracts){
            calendar.setTime(calendar.getTime());
            int calendarYear = calendar.get(Calendar.YEAR);
            int calendarMonth = 1 + calendar.get(Calendar.MONTH);
            if(year == calendarYear && month == calendarMonth){
                sum += contract.totalValue();
            }
        }
        return sum;
    }
}
