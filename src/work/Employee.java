package work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeManagementSystem {

    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Liz Chuene", 35, "HR", 60000));
        employees.add(new Employee("Tito Mboweni", 28, "IT", 75000));
        employees.add(new Employee("Jacob Zuma", 42, "Finance", 80000));
        // Add more employees as needed

        // Step 1: Read the dataset and store it in a collection
        // Already done with the sample dataset

        // Step 2: Write a function using the Function interface
        // Concatenate name and department using Function interface
        Function<Employee, String> concatenateFunction = e -> e.name + " - " + e.department;

        // Step 3: Use streams to generate a new collection
        List<String> concatenatedList = employees.stream()
                .map(concatenateFunction)
                .collect(Collectors.toList());

        // Display the concatenated strings
        System.out.println("Concatenated Strings: " + concatenatedList);

        // Step 4: Enhance the program to find the average salary using streams
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // Display the average salary
        System.out.println("Average Salary: " + averageSalary);

        // Step 5: Generalize the program with a filter function based on age
        int ageThreshold = 30;
        List<Employee> filteredList = employees.stream()
                .filter(e -> e.age > ageThreshold)
                .collect(Collectors.toList());

        // Display the filtered list
        System.out.println("Employees above " + ageThreshold + " years: " + filteredList);

        // Additional Features:

        // 1. Sorting employees by salary in descending order
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Display the sorted list
        System.out.println("Employees sorted by salary (descending): " + sortedBySalary);

        // 2. Finding the highest-paid employee
        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        // Display the highest-paid employee
        System.out.println("Highest Paid Employee: " + highestPaidEmployee);
    }
}
