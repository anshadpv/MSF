package Sample;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private String name;
	private int id;
	private String department;
	
	public Employee(int id, String name, String department) {
		this.id=id;
		this.name=name;
		this.department=department;
	}
	
	public String toString() {
		return "ID : "+id+" Name : "+name+" Department : "+department; 
	}
	
}

public class EmployeeManagement {
	public static void main(String  []args) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		Map<Integer, Employee> employeeMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Employee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. Retrieve Employee");
			System.out.println("3. List all Employee's");
			System.out.println("4. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 :
				System.out.println("Enter Employee id : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee name : ");
				String name = sc.nextLine();
				System.out.println("Enter Employee department : ");
				String department  = sc.nextLine();
				
				Employee employee = new Employee(id, name, department);
				employeeList.add(employee);
				employeeMap.put(id, employee);
				System.out.println("Employee added successfully.");
				break;
				
			case 2 :
				System.out.println("Enter Employee id to retrieve details : ");
				int retrieveId = sc.nextInt();
				Employee retrievedEmployee = employeeMap.get(retrieveId);
				if (retrievedEmployee!=null) {
					System.out.println("Employee Details.");
					System.out.println(retrievedEmployee);
				}
				else {
					System.out.println("Employee not found.");
				}
				break;
			
			case 3 :
				System.out.println("List of all Employee's.");
				for (Employee emp : employeeList) {
					System.out.println(emp);
				}
				break;
				
			case 4 :
				System.out.println("Exiting Program.");
				System.exit(0);
				
			default :
				System.out.println("Invalid choice.");
				break;
			}
		}
	}

}
