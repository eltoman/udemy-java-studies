package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter Salary: ");
            Double salaryTarget = sc.nextDouble();

            System.out.println("E-mails of people whose salary is  more than " + salaryTarget + ":");

            list.stream().filter(x -> x.getSalary() > salaryTarget)
                    .map(y -> y.getEmail())
                    .sorted()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            String letterStartName = "M";

            Double sumSalaryNamesByFirstLetter=
                    list.stream().filter(x -> x.getName().toUpperCase().startsWith(letterStartName))
                    .map(y -> y.getSalary())
                    .reduce(0.0, (x, y)  -> x + y);

            System.out.println("Sum of salary of people whose name start with `" + letterStartName + "`: " + sumSalaryNamesByFirstLetter);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}