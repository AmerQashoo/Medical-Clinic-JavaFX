package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		root.setSpacing(5);
		
		HBox Title = new HBox();
		Label title = new Label("Medical Clinic  System");
		title.setFont(new Font("Arial",20));
		Title.getChildren().add(title);
		Title.setAlignment(Pos.CENTER);
		
		HBox Title1 = new HBox();
		Label title1 = new Label("  1) Patient Information:");
		title1.setFont(new Font("Arial",15));
		Title1.getChildren().add(title1);

		GridPane patient = new GridPane();
		Label Name = new Label("Name");
		TextField name = new TextField();
		Label DateOfBirth = new Label("Date Of Birth");
		TextField dateOfBirth = new TextField();
		Label Gender = new Label("Gender");
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		ToggleGroup group = new ToggleGroup();
		male.setToggleGroup(group);
		female.setToggleGroup(group);
		HBox gender = new HBox();
		gender.getChildren().addAll(male, female);
		gender.setSpacing(10);
		Label City = new Label("City");
		TextField city = new TextField();
		Label Occupation = new Label("Occupation");
		TextField occupation = new TextField();
		CheckBox hasInsurance = new CheckBox("Has Insurance");
		patient.add(Name, 0, 0);
		patient.add(name, 1, 0);
		patient.add(DateOfBirth, 0, 1);
		patient.add(dateOfBirth, 1, 1);
		patient.add(Gender, 0, 2);
		patient.add(gender, 1, 2);
		patient.add(City, 0, 3);
		patient.add(city, 1, 3);
		patient.add(Occupation, 0, 4);
		patient.add(occupation, 1, 4);
		patient.add(hasInsurance, 1, 5);
		patient.setHgap(150);
		patient.setVgap(5);

		HBox Title2 = new HBox();
		Label title2 = new Label("  2)Clinic  Information:");
		Title2.getChildren().add(title2);
		title2.setFont(new Font("Arial",15));

		GridPane clinic = new GridPane();
		Label ClinicName = new Label("Clinic Name");
		TextField clinicName = new TextField();
		Label Location = new Label("Location");
		TextField location = new TextField();
		Label Telephone = new Label("Telephone");
		TextField telephone = new TextField();
		clinic.add(ClinicName, 0, 0);
		clinic.add(clinicName, 1, 0);
		clinic.add(Location, 0, 1);
		clinic.add(location, 1, 1);
		clinic.add(Telephone, 0, 2);
		clinic.add(telephone, 1, 2);
		clinic.setHgap(155);
		clinic.setVgap(5);

		HBox Title3 = new HBox();
		Label title3 = new Label("  3)Incident Information:");
		Title3.getChildren().add(title3);
		title3.setFont(new Font("Arial",15));
		GridPane Incident = new GridPane();
		Label IncidentDate = new Label("Incident Date");
		TextField incidentDate = new TextField();
		Label Severity = new Label("Severity");
		ComboBox<String> severity = new ComboBox<>();
		severity.getItems().add("LOW");
		severity.getItems().add("MEDIUM");
		severity.getItems().add("HIGH");
		Label BodyPart = new Label("Body Part");
		TextField bodyPart = new TextField();

		Incident.add(Severity, 0, 1);
		Incident.add(severity, 1, 1);
		Incident.add(BodyPart, 0, 2);
		Incident.add(bodyPart, 1, 2);
		Incident.setHgap(167);
		Incident.setVgap(5);

		HBox button = new HBox();
		Button Save = new Button("Save");
		Button Clear = new Button("Clear");
		button.getChildren().addAll(Save, Clear);
		button.setAlignment(Pos.CENTER);

		Clear.setOnAction(e -> {
			name.setText("");
			dateOfBirth.setText("");
			male.setSelected(false);
			female.setSelected(false);
			city.setText("");
			occupation.setText("");
			hasInsurance.setSelected(false);
			clinicName.setText("");
			location.setText("");
			telephone.setText("");
			incidentDate.setText("");
			severity.setValue("");
			bodyPart.setText("");
		});
		Save.setOnAction(e -> {
			if (name.getText().trim().isEmpty()) {
				alert("Please enter patient name");
				return;
			}
			if (dateOfBirth.getText().trim().isEmpty()) {
				alert("Please enter date of birth");
				return;
			}
			String date = dateOfBirth.getText().trim();
			if (!cheekDate(date)) {
				alert("Date of Birth must be in dd/MM/yyyy format!");
				return;
			}
			if (group.getSelectedToggle() == null) {
				alert("Please select gender");
				return;
			}
			if (city.getText().trim().isEmpty()) {
				alert("Please enter city");
				return;
			}
			if (occupation.getText().trim().isEmpty()) {
				alert("Please enter occupation");
				return;
			}
			if (clinicName.getText().trim().isEmpty()) {
				alert("Please enter clinic name");
				return;
			}
			if (location.getText().trim().isEmpty()) {
				alert("Please enter location");
				return;
			}
			if (telephone.getText().trim().isEmpty()) {
				alert("Please enter telephone");
				return;
			}

			if (severity.getValue() == null) {
				alert("Please enter severity");
				return;
			}
			if (bodyPart.getText().trim().isEmpty()) {
				alert("Please enter body part");
				return;
			}
			String check;
if(hasInsurance.isSelected()) {
	check="true";
}else {
	check="false";

}
			Patient patient1 = new Patient(name.getText(), dateOfBirth.getText(),
					((RadioButton) group.getSelectedToggle()).getText(), city.getText(), occupation.getText(),
					check);
			Clinic clinic1 = new Clinic(clinicName.getText(), location.getText(), telephone.getText());
			Incident incident1 = new Incident(severity.getValue(), bodyPart.getText(), null, "", "", patient1, clinic1);
			patient1.giveVisit().add(incident1); 

			FileManager file = new FileManager();
			file.savePatientVisit(patient1);

		});

		root.getChildren().addAll(Title, Title1, patient, Title2, clinic, Title3, Incident, button);
		Scene scene = new Scene(root, 1000, 450);
		primaryStage.setTitle("Medical Clinic  System ");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private void alert(String message) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private boolean cheekDate(String date) {
		String[] part = date.split("/");
		if (part.length != 3) {
			return false;
		}
		String day = part[0];
		String month = part[1];
		String year = part[2];
		try {
			int d = Integer.parseInt(day);
			int m = Integer.parseInt(month);
			int y = Integer.parseInt(year);
			if (d < 1 || d > 31 || m < 1 || m > 12 || y < 1900) {
				return false;
			}
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}

	}
}
