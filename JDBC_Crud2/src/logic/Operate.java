package logic;

import java.util.Scanner;

import bean.Employee;
import dao.DBoperation;

public class Operate {
public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	Employee e = new Employee();
	int v = 10;
	
	while(v!=0) {
		System.out.println("Please choose an option: ");
		System.out.println("Enter 1 to insert data\n Enter 2 to update data\n Enter 3 to Delete data\n Enter 4 to View Data\n Enter 0 to Exit");
	v=sc.nextInt();
	
	switch(v) {
	
	case 1:
		System.out.println("Enter ID");
		e.setId(sc.nextInt());
		System.out.println("Enter Name");
		e.setName(sc.next()+sc.nextLine());
		System.out.println("Enter Age");
		e.setAge(sc.nextInt());
		System.out.println("Enter Salary");
		e.setSalary(sc.nextInt());
		
		DBoperation.insert(e);
		break;
		
	case 2:
		System.out.println("Enter ID");
		e.setId(sc.nextInt());
		System.out.println("Enter Name");
		e.setName(sc.next()+sc.nextLine());
		System.out.println("Enter Age");
		e.setAge(sc.nextInt());
		System.out.println("Enter Salary");
		e.setSalary(sc.nextInt());
		
		DBoperation.update(e);
		break;
		
	case 3:
		System.out.println("Enter Id");
		DBoperation.delete(sc.nextInt());
		break;
		
	case 4:
		DBoperation.view();
		break;
		
		default: System.out.println("Invalid choice !");
	}
}
}
}