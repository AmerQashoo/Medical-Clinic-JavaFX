package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

	public void savePatientVisit(Patient patient1) {

		String fileName = "Medical Clinic  System.txt";

		try {
			FileWriter F = new FileWriter(fileName, true); 
			PrintWriter P = new PrintWriter(F);
			P.println(patient1.getName() + "," + patient1.getDateOfBirth() + "," + patient1.getGender() + ","
					+ patient1.getCity() + "," + patient1.getOccupation() + "," + patient1.getHasInsurance() + ".");
			for (int i = 0; i < patient1.giveVisit().size(); i++) {
				Visit v = patient1.giveVisit().get(i);
				Clinic c = v.getClinic();
				P.println(c.getClinicName() + "," + c.getLocation() + "," + c.getTelephone() + ".");
				if (v instanceof Incident) {
					Incident incident = (Incident) v;
					P.println(incident.getSeverity() + "," + incident.getBodyPart() + ".");

				}
			}

			P.close();


		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}
}
