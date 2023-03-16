package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Employee;

public class DBoperation {
	
	static Connection con = null;
	
	public static void connect() {
		
		String url = "jdbc:mysql://localhost:3306/java330";
		String uname = "root";
		String upass = "root";
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, upass);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void insert(Employee e) {
		connect();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into employe value(?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getAge());
			ps.setInt(4, e.getSalary());
			
			if(!ps.execute()) {
			System.out.println("Data inserted successfully");	
			} 
			else {
				System.out.println("Data insertion failed");
			}
			con.close();
			}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public static void update(Employee e) {
		connect();	
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from employe where id = ?");
			ps.setInt(1, e.getId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Employee e1 = new Employee();
		e1.setName(rs.getString(2));
		e1.setId(rs.getInt(3));
		e1.setSalary(rs.getInt(4));
		
		if(!e.getName().equals("null")) 
		{
	    e1.setName(e.getName());
		}
		if(e.getAge()!=0) 
		{
		e1.setAge(e.getAge());
		}
		if(e.getSalary()!=0)
		{
			e1.setSalary(e.getSalary());
		}
		
		ps = con.prepareStatement("update employe set name=?, age=?, salary=? where id=?");
		ps.setString(1, e1.getName());
		ps.setInt(2, e1.getAge());
		ps.setInt(3, e1.getSalary());
		ps.setInt(4, e.getId());
		
		if(!ps.execute()) {
			System.out.println("Data updated successfully");
			System.out.println(e.getId()+" "+e1.getName()+" "+e1.getAge()+" "+e1.getSalary());
		}
		else {
			System.out.println("!Data updation failed");
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
			PreparedStatement ps = con.prepareStatement("delete from employe where id=?");
			ps.setInt(1, id);

			if(!ps.execute()) {
				System.out.println("data deleted");
			}
			else {
				System.out.println("data not deleted");
			}
			con.close();
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void view() {
		connect();		
		try {
			PreparedStatement ps = con.prepareStatement("select * from employe");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(1)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
			
			con.close();
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}