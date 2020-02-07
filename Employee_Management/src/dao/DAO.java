package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
import databaseutil.DatabaseUtil;


public class DAO {
	
	DatabaseUtil ut = new DatabaseUtil(); 
	
	Connection con = null;
	int status = 0;
	
	public int add(Employee e) throws SQLException 
	{
		try
		{
			con=ut.getConnection();
			String s = "insert into EMPLOYEE(id,name,password,email,country) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());
			status = ps.executeUpdate();
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<Employee> getAllEmployees() throws SQLException
	{
		ArrayList<Employee> alist = new ArrayList<>();
		con = ut.getConnection();
		String s = "select * from Employee";
		PreparedStatement ps = con.prepareStatement(s);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setPassword(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setCountry(rs.getString(5));
			
			alist.add(emp);
		}
		return alist;
	}

	public int delete(int id) {
		try
		{
			con = ut.getConnection();
			String s = "delete from Employee where id=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, id);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	public int update(int id, String name, String password, String email, String country) {
		
		try
		{
			con = ut.getConnection();
			String s = "update Employee set name = ?, password = ?, email = ?, country = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, country);
			ps.setInt(5, id);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

}
