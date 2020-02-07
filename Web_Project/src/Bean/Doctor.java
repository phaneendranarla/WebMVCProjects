package Bean;

import java.util.ArrayList;

public class Doctor {
	
	private int doctorId;
	private String doctorName;
	private String doctorSpecialization;
	private int doctorExperience;
	
	ArrayList<Patient> ap = new ArrayList<Patient>();

	public Doctor(int doctorId, String doctorName, String doctorSpecialization, int doctorExperience,
			ArrayList<Patient> ap) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorExperience = doctorExperience;
		this.ap = ap;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public int getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(int doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public ArrayList<Patient> getAp() {
		return ap;
	}

	public void setAp(ArrayList<Patient> ap) {
		this.ap = ap;
	}
	
	
	
}
