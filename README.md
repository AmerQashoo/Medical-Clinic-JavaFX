# Medical Clinic System — JavaFX

A JavaFX graphical interface developed for the incident-recording part of a university medical clinic OOP project. This is a separate GUI component of the [Java console project](https://github.com/AmerQashoo/Medical-Clinic-Management-System).

## Features

- Enter patient details, including name, date of birth, gender, city, occupation, and insurance status.
- Enter clinic name, location, and phone number.
- Select injury severity and specify the affected body part.
- Validate required fields and the basic date format before saving.
- Save patient, clinic, and incident information to a local text file.
- Clear input fields using the Clear button.

## Technologies

- Java
- JavaFX (controls, layouts, events and alerts)
- Object-oriented programming
- Text file output

## Running the project

The source files are in the `application` package. To run the GUI, use a Java IDE configured with the **JavaFX SDK** (for example Eclipse or IntelliJ IDEA). Set `application.Main` as the main class. JavaFX must be installed and configured separately when not included with your Java installation.

The program writes to `Medical Clinic  System.txt` in the current working directory when Save is pressed.

## Notes and limitations

- The GUI focuses on entering incident records; it does not provide the four visit types from the console project.
- The incident-date field is declared but not displayed or saved in this version. The visit date passed to the incident is `null`.
- Date validation checks numeric day/month ranges, not full calendar validity (for example, February 30 is not rejected).
- Saving appends records to a local text file; this is an educational prototype, not a production medical-record system.
- `application.css` is included as an IDE-generated placeholder and is not actively used in the scene.

## Related project

[Medical Clinic Management System (Java Console)](https://github.com/AmerQashoo/Medical-Clinic-Management-System)
