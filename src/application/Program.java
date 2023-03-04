package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourceEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> empList = new ArrayList<>();
		
		System.out.print("Enter the number of emplyes: ");
		int n = sc.nextInt();
		
		
		for(int i=1; i<=n; i++) {	
			System.out.printf("Employee #%d data: %n", i);
			System.out.print("Outsourced (y/n)?");
			char opt = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			
			int hours = sc.nextInt();
			System.out.print("Valuye per Hour: ");
			double valuePerHour = sc.nextDouble();
			sc.nextLine();
			
			if(opt == 'y') {
				System.out.print("Additional charge: ");
				double addCharge = sc.nextDouble();
				empList.add(new OutSourceEmployee(name, hours, valuePerHour, addCharge));
			}else {
				empList.add(new Employee(name, hours, valuePerHour));
			}
		}//End for
		
		System.out.println("");
		System.out.println("PAYMENTS");
		for(Employee emp : empList) {
			System.out.println(emp.toString());
		}
		
		
		sc.close();
	}

}
