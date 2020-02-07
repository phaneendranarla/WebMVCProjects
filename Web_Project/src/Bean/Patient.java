package Bean;

public class Patient {
	
	private int patientId;
	private String patientName;
	private String patientStatus;
	private String patientInvestigation;
	private String patientAddress;
	
	public Patient(int patientId, String patientName, String patientStatus, String patientInvestigation, 
			String patientAddress) {
		// TODO Auto-generated constructor stub
		
		this.patientId = patientId;
		this.patientName = patientStatus;
		this.patientStatus = patientStatus;
		this.patientInvestigation = patientInvestigation;
		this.patientAddress = patientAddress;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getPatientInvestigation() {
		return patientInvestigation;
	}

	public void setPatientInvestigation(String patientInvestigation) {
		this.patientInvestigation = patientInvestigation;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	
}
