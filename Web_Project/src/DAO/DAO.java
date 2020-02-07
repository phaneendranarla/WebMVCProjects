package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Doctor;
import Bean.Patient;
import DatabaseUtil.DatabaseUtil;

public class DAO {
	
	DatabaseUtil ut = new DatabaseUtil(); 
	
	Connection con = null;
	
	public int log(int id) 
	{
		try
		{
			con=ut.getConnection();
			String s="select * from TBL_Patient_1430870 where PatientId=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet r=ps.executeQuery();
			if(r.next())
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<Doctor> search(int id)
	{
		ArrayList<Doctor> alist=new ArrayList<Doctor>(); 
		try
		{
			con=ut.getConnection();
			//String s1="select TBL_Patient_1430870.PatientId,TBL_Patient_1430870.PatientName,TBL_Patient_1430870.PatientStatus,TBL_Patient_1430870.PatientInvestigation,TBL_Doctor_1430870.DoctorId,TBL_Doctor_1430870.DoctorName,TBL_Doctor_1430870.DoctorSpecialization from TBL_Patient_1430870 inner join TBL_Doctor_1430870 on TBL_Patient_1430870.DoctorId=TBL_Doctor_1430870.DoctorId where PatientId=?";
			PreparedStatement ps=con.prepareStatement("select TBL_Patient_1430870.PatientId,TBL_Patient_1430870.PatientName,TBL_Patient_1430870.PatientStatus,TBL_Patient_1430870.PatientInvestigation,TBL_Doctor_1430870.DoctorId,TBL_Doctor_1430870.DoctorName,TBL_Doctor_1430870.DoctorSpecialization from TBL_Patient_1430870 inner join TBL_Doctor_1430870 on TBL_Patient_1430870.DoctorId=TBL_Doctor_1430870.DoctorId  where TBL_Patient_1430870.PatientId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 
			
			while(rs.next())
			{
				Doctor d=new Doctor();
				d.setDoctorId(rs.getInt("DoctorId"));
				d.setDoctorName(rs.getString("DoctorName"));
				d.setDoctorSpecialization(rs.getString("DoctorSpecialization"));
				ArrayList<Patient> alist1= new ArrayList<Patient>();
				Patient p=new Patient();
				p.setPatientId(rs.getInt("PatientId"));
				p.setPatientName(rs.getString("PatientName"));
				p.setPatientStatus(rs.getString("PatientStatus"));
				p.setPatientInvestigation(rs.getString("PatientInvestigation"));
				
				alist1.add(p);
				d.setAp(alist1);
				alist.add(d);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;
		
		
	}
	
	public int update(int id , String text)
	{
		try
		{
			con=ut.getConnection();
			PreparedStatement ps = con.prepareStatement("update TBL_Patient_1430870 set PatientInvestigation=?, PatientStatus='Bill in Progress' where PatientId=?");
			ps.setString(1, text);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
