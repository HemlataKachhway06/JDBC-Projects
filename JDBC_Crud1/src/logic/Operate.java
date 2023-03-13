package logic;

import java.util.Scanner;

import bean.Employees;
import dao.DbOperation;

public class Operate {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employees e = new Employees();
		int v=10;
		
		while(v!=0) {
			System.out.println("Please choose the task :");
			System.out.println("press 1 to insert data\n press 2 to update data\n press 3 to delete data\n press 4 to view data\n press 0 to exit");
			v=sc.nextInt();
			
			switch(v) {
			
			case 1: System.out.println("Enter id: ");
			e.setId(sc.nextInt());
			System.out.println("Enter name: ");
			e.setName(sc.next()+sc.nextLine());
			System.out.println("Enter department: ");
			e.setDepartment(sc.next()+sc.nextLine());
			System.out.println("Enter salary");
			e.setSalary(sc.nextInt());
			
			DbOperation.insert(e);
			break;
			
			case 2: System.out.println("Enter id: ");
			e.setId(sc.nextInt());
			System.out.println("Enter name: ");
			e.setName(sc.next()+sc.nextLine());
			System.out.println("Enter department: ");
			e.setDepartment(sc.next()+sc.nextLine());
			System.out.println("Enter salary");
			e.setSalary(sc.nextInt());
			
			DbOperation.update(e);;
			break;
			
			case 3:
				System.out.println("Enter id: ");
				DbOperation.delete(sc.nextInt());
				break;
				
			case 4:
				DbOperation.viewData();
				break;
				
				default: System.out.println("Invalid choice !");
			}			
	}
}
}