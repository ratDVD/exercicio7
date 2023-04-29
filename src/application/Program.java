package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> lista = new ArrayList<>();

		System.out.print("How many employees will be registered?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #:" + i);
			System.out.print("Id:");
			int id = sc.nextInt();
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary:");
			double salary = sc.nextDouble();
			
			lista.add(new Employee(id, name, salary));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase:");
		int id = sc.nextInt();
		
		Employee encontrou = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (encontrou != null) {
			System.out.print("Enter the percentage:");
			double percentage = sc.nextDouble();
			
			encontrou.increaseSalary(percentage);
		} else {
			System.out.println("This id does not exist!");
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee a : lista) {
			System.out.println(a.toString());
		}

		sc.close();

	}

}
