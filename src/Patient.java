/**
 * Patient.java
 *
 * Holds the details of a single patient. Every Patient object also
 * owns its own VisitHistory, so a patient's past visits stay attached
 * to the patient record itself instead of being stored somewhere else.
 */
public class Patient {

    // Used as the BST key, so it can never change once a patient is created.
    private final int patientId;

    private String fullName;
    private int age;
    private String contactNumber;
    private String medicalCondition;

    private VisitHistory visitHistory;

    public Patient(int patientId, String fullName, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;

        // A brand new patient always starts with an empty visit history.
        this.visitHistory = new VisitHistory();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public VisitHistory getVisitHistory() {
        return visitHistory;
    }

    // No setter for patientId on purpose - it's the BST key.
    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException(
                "Age must be between 0 and 120."
            );
        }

        this.age = age;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    /**
     * One-line summary used whenever a patient record is printed.
     */
    @Override
    public String toString() {

        return String.format(
            "ID %-5d | %-22s | Age %-3d | Contact %-12s | Condition: %s",
            patientId,
            fullName,
            age,
            contactNumber,
            medicalCondition
        );
    }
}
