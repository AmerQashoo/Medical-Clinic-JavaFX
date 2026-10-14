package application;

import java.util.Date;

public class Incident extends Visit {
	private String severity;
	private String bodyPart;

	public Incident() {
	}

	public Incident(String severity, String bodyPart,Date visitDate, String symptoms, String diagnosis, Patient patient,Clinic clinic) {
		super(visitDate, symptoms, diagnosis, patient,clinic);
		this.severity = severity;
		this.bodyPart = bodyPart;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	  @Override
	    public void generateReport() {
	    	System.out.println("Information for Incident:");
	    	System.out.println("VisitDate: "+getVisitDate());
	    	System.out.println("Symptoms: "+getSymptoms());
	    	System.out.println("Diagnosis: "+getDiagnosis());
	    	System.out.println("severity: "+severity);
	    	System.out.println("bodyPart: "+bodyPart);
}
}