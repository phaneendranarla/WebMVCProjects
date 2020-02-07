package service;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.Employee;
import dao.DAO;

public class Service {
	
	DAO d = new DAO();

	public int add(Employee emp) throws SQLException {
		
		return d.add(emp);
	}

	public ArrayList<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return d.getAllEmployees();
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return d.delete(id);
	}

	public int update(int id, String name, String password, String email, String country) {
		// TODO Auto-generated method stub
		return d.update(id,name,password,email,country);
	}

}
