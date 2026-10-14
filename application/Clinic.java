package application;
import java.util.*;

public class Clinic {
	private String clinicName;
	private String location;
	private String telephone;
	private ArrayList<Visit> visits;


	public Clinic() {

	}
	public Clinic(String clinicName, String location, String telephone) {
		this.clinicName = clinicName;
		this.location = location;
		this.telephone = telephone;
		this.visits =new ArrayList<>();
	}


	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	 public void addVisits(Visit v) {
		 visits.add(v);
	 }
	public ArrayList<Visit> giveVisits(){
		return visits;
	}
}
