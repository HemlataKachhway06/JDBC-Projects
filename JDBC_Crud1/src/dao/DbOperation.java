package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Employees;

public class DbOperation {
	static Connection con = null;
	
	public static void connect() {
		String url = "jdbc:mysql://localhost:3306/java330";
		String uname = "root";
		String upass = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upass);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void insert(Employees e) {
		
		connect();		
		try {
			PreparedStatement ps = con.prepareStatement("insert into Employees value(?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getDepartment());
		ps.setInt(4, e.getSalary());
		
		if(!ps.execute()) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data not inserted");
		}
		con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void update(Employees e1) 
	{
		connect();		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Employees where id = ?");
			ps.setInt(1, e1.getId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Employees e = new Employees();
			e.setName(rs.getString(2));
			e.setDepartment(rs.getString(3));
			e.setSalary(rs.getInt(4));		
			
			if(!e1.getName().equals("null")) {
				e.setName(e1.getName());
			}
			if(!e1.getDepartment().equals("null")) {
				e.setName(e1.getDepartment());
			}
			if(e1.getSalary()!=0) {
				e.setSalary(e1.getSalary());
			}
			
			ps = con.prepareStatement("update Employees set Name=?, Department=?,Salary=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getDepartment());
			ps.setInt(3, e.getSalary());
			ps.setInt(4, e1.getId());
			
			if(!ps.execute()) {
				System.out.println("data updated");
				System.out.println(e1.getId()+" "+e.getName()+" "+e.getDepartment()+" "+e.getSalary());
			}
			else {
				System.out.println("could not perform update");
			}
		con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void delete(int id) {
		connect();		
		try {
			PreparedStatement ps = con.prepareStatement("delete from Employees where id=?");
			ps.setInt(1, id);
			
			if(!ps.execute()){
				System.out.println("record deleted");
			}
			else {
				System.out.println("record not deleted");
			}
			
		con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void viewData() {
		connect();		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Employees");
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			 }
		con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}