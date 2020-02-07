package Service;

import java.util.ArrayList;

import Bean.Doctor;
import DAO.DAO;

public class Service {
	
	DAO d = new DAO();
	
	public int login(int id)
	{
		return d.log(id);
	}

	public ArrayList<Doctor> search(int id)
	{
		return d.search(id);
	}

	public int update(int id, String text) {
		// TODO Auto-generated method stub
		return d.update(id, text);
	}
}
