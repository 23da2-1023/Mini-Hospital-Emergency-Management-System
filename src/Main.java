import java.util.Scanner;

/**
 * Main.java
 * Console entry point for the Northwood General Hospital emergency
 * management system. Wires together the patient BST, the emergency
 * queue and the treatment stack, and drives the menu loop.
 */
public class Main {

    public static void main(String[] args) {

        // ========================================================
        // SET UP THE DATA STRUCTURES
        // ========================================================

        PatientBST patientRecords = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentHistory = new TreatmentStack();

        Scanner scanner = new Scanner(System.in);


        int choice;


        // ========================================================
        // MAIN MENU LOOP
        // ========================================================

        do {

            printMainMenu();

            choice = readInt(scanner, "Select an option: ");

            switch (choice) {

                // ----------------------------------------------
                // OPTION 1: REGISTER PATIENT
                // ----------------------------------------------
                case 1: {

                    System.out.println("\n--- Register New Patient ---");

                    int id = readInt(scanner, "Patient ID: ");

                    if (patientRecords.search(id) != null) {
                        System.out.println("That patient ID is already in use.");
                        break;
                    }

                    System.out.print("Full name: ");
                    String name = scanner.nextLine();

                    int age = readInt(scanner, "Age: ");

                    System.out.print("Contact number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Medical condition: ");
                    String condition = scanner.nextLine();

                    patientRecords.insert(new Patient(id, name, age, contact, condition));

                    System.out.println("Patient record created.");
                    break;
                }

                // ----------------------------------------------
                // OPTION 2: SEARCH PATIENT
                // ----------------------------------------------
                case 2: {

                    System.out.println("\n--- Search Patient Records ---");

                    int id = readInt(scanner, "Patient ID: ");
                    Patient found = patientRecords.search(id);

                    if (found != null) {
                        System.out.println("Match found:");
                        System.out.println(found);
                    } else {
                        System.out.println("No patient record was found for ID " + id + ".");
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 3: DELETE PATIENT
                // ----------------------------------------------
                case 3: {

                    System.out.println("\n--- Remove Patient Record ---");

                    int id = readInt(scanner, "Patient ID: ");
                    Patient toRemove = patientRecords.search(id);

                    if (toRemove == null) {
                        System.out.println("No patient record was found for ID " + id + ".");
                    } else {
                        patientRecords.delete(id);
                        System.out.println("Patient record removed.");
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 4: DISPLAY ALL PATIENTS
                // ----------------------------------------------
                case 4:

                    System.out.println("\n--- All Registered Patients ---");
                    patientRecords.displayInOrder();
                    break;

                // ----------------------------------------------
                // OPTION 5: ADD TO EMERGENCY QUEUE
                // ----------------------------------------------
                case 5: {

                    System.out.println("\n--- Send Patient to Emergency Queue ---");

                    int id = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(id);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + id + ".");
                    } else {
                        emergencyQueue.enqueue(patient);
                        System.out.println(patient.getName() + " has been added to the emergency queue.");
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 6: TREAT NEXT EMERGENCY PATIENT
                // ----------------------------------------------
                case 6: {

                    System.out.println("\n--- Call Next Patient ---");

                    Patient nextPatient = emergencyQueue.dequeue();

                    if (nextPatient != null) {
                        System.out.println("Now treating:");
                        System.out.println(nextPatient);
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 7: DISPLAY EMERGENCY QUEUE
                // ----------------------------------------------
                case 7:

                    System.out.println("\n--- Emergency Queue ---");
                    emergencyQueue.display();
                    break;

                // ----------------------------------------------
                // OPTION 8: COMPLETE TREATMENT
                // ----------------------------------------------
                case 8: {

                    System.out.println("\n--- Log Completed Treatment ---");

                    int id = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(id);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + id + ".");
                        break;
                    }

                    System.out.print("Patient name: ");
                    String name = scanner.nextLine();

                    System.out.print("Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Attending doctor: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Treatment date (DD-MM-YYYY): ");
                    String date = scanner.nextLine();

                    treatmentHistory.push(new TreatmentRecord(id, name, diagnosis, doctor, date));

                    System.out.println("Treatment record saved.");
                    break;
                }

                // ----------------------------------------------
                // OPTION 9: VIEW TREATMENT HISTORY
                // ----------------------------------------------
                case 9:

                    System.out.println("\n--- Treatment History ---");
                    treatmentHistory.display();
                    break;

                // ----------------------------------------------
                // OPTION 10: POP LAST TREATMENT
                // ----------------------------------------------
                case 10: {

                    System.out.println("\n--- Undo Last Treatment Entry ---");

                    TreatmentRecord removed = treatmentHistory.pop();

                    if (removed != null) {
                        System.out.println("Removed the most recent entry:");
                        System.out.println(removed);
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 11: ADD PATIENT VISIT
                // ----------------------------------------------
                case 11: {

                    System.out.println("\n--- Log a Patient Visit ---");

                    int patientId = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(patientId);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + patientId + ".");
                        break;
                    }

                    int visitId = readInt(scanner, "Visit ID: ");

                    System.out.print("Visit date (DD-MM-YYYY): ");
                    String visitDate = scanner.nextLine();

                    System.out.print("Attending doctor: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Treatment given: ");
                    String treatment = scanner.nextLine();

                    patient.getVisitHistory().addVisit(
                        new Visit(visitId, visitDate, doctor, diagnosis, treatment)
                    );

                    System.out.println("Visit logged for " + patient.getName() + ".");
                    break;
                }

                // ----------------------------------------------
                // OPTION 12: SEARCH PATIENT VISIT
                // ----------------------------------------------
                case 12: {

                    System.out.println("\n--- Search a Patient's Visit ---");

                    int patientId = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(patientId);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + patientId + ".");
                        break;
                    }

                    int visitId = readInt(scanner, "Visit ID: ");
                    Visit found = patient.getVisitHistory().searchVisit(visitId);

                    if (found != null) {
                        System.out.println("Match found:");
                        System.out.println(found);
                    } else {
                        System.out.println("No visit with ID " + visitId + " was found for this patient.");
                    }

                    break;
                }

                // ----------------------------------------------
                // OPTION 13: REMOVE PATIENT VISIT
                // ----------------------------------------------
                case 13: {

                    System.out.println("\n--- Remove a Patient's Visit ---");

                    int patientId = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(patientId);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + patientId + ".");
                        break;
                    }

                    int visitId = readInt(scanner, "Visit ID: ");
                    patient.getVisitHistory().removeVisit(visitId);

                    break;
                }

                // ----------------------------------------------
                // OPTION 14: DISPLAY PATIENT VISIT HISTORY
                // ----------------------------------------------
                case 14: {

                    System.out.println("\n--- Full Visit History ---");

                    int patientId = readInt(scanner, "Patient ID: ");
                    Patient patient = patientRecords.search(patientId);

                    if (patient == null) {
                        System.out.println("No patient record was found for ID " + patientId + ".");
                        break;
                    }

                    patient.getVisitHistory().display();
                    break;
                }

                // ----------------------------------------------
                // OPTION 15: EXIT
                // ----------------------------------------------
                case 15:

                    System.out.println("\nShutting down the console. Take care!");
                    break;

                default:

                    System.out.println("That's not a valid option - please pick a number from the menu.");
            }

        } while (choice != 15);

        scanner.close();
    }


    // ============================================================
    // MENU BANNER
    // ============================================================

    private static void printMainMenu() {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("        NORTHWOOD GENERAL HOSPITAL");
        System.out.println("        Emergency Management Console");
        System.out.println("==================================================");
        System.out.println(" [ 1] Register New Patient");
        System.out.println(" [ 2] Search Patient Records");
        System.out.println(" [ 3] Remove Patient Record");
        System.out.println(" [ 4] List All Patients");
        System.out.println(" [ 5] Send Patient to Emergency Queue");
        System.out.println(" [ 6] Call Next Patient");
        System.out.println(" [ 7] View Emergency Queue");
        System.out.println(" [ 8] Log Completed Treatment");
        System.out.println(" [ 9] View Treatment History");
        System.out.println(" [10] Undo Last Treatment Entry");
        System.out.println(" [11] Log a Patient Visit");
        System.out.println(" [12] Search a Patient's Visit");
        System.out.println(" [13] Remove a Patient's Visit");
        System.out.println(" [14] View Full Visit History");
        System.out.println(" [15] Exit");
        System.out.println("--------------------------------------------------");
    }


    // ============================================================
    // SAMPLE DATA
    // ============================================================

    /**
     * Seeds the system with a handful of fictional patients so the
     * menu options have something to work with right away instead of
     * starting from a completely empty console.
     */
    private static void loadSampleData(PatientBST patientRecords,
                                        EmergencyQueue emergencyQueue,
                                        TreatmentStack treatmentHistory) {

        patientRecords.insert(new Patient(101, "Isha Wickramasinghe", 29, "0771234561", "Dengue Fever"));
        patientRecords.insert(new Patient(102, "Kavindu Perera", 45, "0771234562", "Hypertension"));
        patientRecords.insert(new Patient(103, "Anjali Fernando", 8, "0771234563", "Fractured Arm"));
        patientRecords.insert(new Patient(104, "Ruwan Jayasuriya", 62, "0771234564", "Chest Pain"));
        patientRecords.insert(new Patient(105, "Dilani Rathnayake", 34, "0771234565", "Appendicitis"));
        patientRecords.insert(new Patient(106, "Chamara Gunawardena", 51, "0771234566", "Diabetic Complications"));
        patientRecords.insert(new Patient(107, "Nadeesha Abeywickrama", 19, "0771234567", "Severe Allergic Reaction"));
        patientRecords.insert(new Patient(108, "Sampath Bandara", 71, "0771234568", "Stroke Symptoms"));
        patientRecords.insert(new Patient(109, "Thilini Wijesekara", 27, "0771234569", "Deep Laceration"));
        patientRecords.insert(new Patient(110, "Harsha Kodithuwakku", 39, "0771234570", "Kidney Stones"));

        // A few patients are already waiting when the console starts.
        emergencyQueue.enqueue(patientRecords.search(104));
        emergencyQueue.enqueue(patientRecords.search(108));
        emergencyQueue.enqueue(patientRecords.search(105));

        // A couple of treatments already logged.
        treatmentHistory.push(new TreatmentRecord(
            101, "Isha Wickramasinghe", "Dengue Fever", "Dr. Senanayake", "12-08-2026"
        ));
        treatmentHistory.push(new TreatmentRecord(
            103, "Anjali Fernando", "Fractured Arm", "Dr. Amarasekara", "20-08-2026"
        ));

        // Some patients already have visit history on record.
        patientRecords.search(102).getVisitHistory().addVisit(
            new Visit(1, "02-06-2026", "Dr. Ilangakoon", "Routine Checkup", "Blood pressure monitoring")
        );
        patientRecords.search(102).getVisitHistory().addVisit(
            new Visit(2, "14-07-2026", "Dr. Ilangakoon", "Hypertension", "Prescribed medication adjustment")
        );
        patientRecords.search(106).getVisitHistory().addVisit(
            new Visit(1, "25-05-2026", "Dr. Wanigasekara", "Diabetic Complications", "Insulin dosage review")
        );
    }


    // ============================================================
    // SAFE INTEGER INPUT HELPER
    // ============================================================

    /**
     * Keeps asking until the user types a valid whole number, so a
     * stray letter doesn't crash the console.
     */
    private static int readInt(Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();   // clear the leftover newline
                return value;

            } else {

                System.out.println("Please enter a whole number.");
                scanner.nextLine();   // discard the bad input
            }
        }
    }
}
