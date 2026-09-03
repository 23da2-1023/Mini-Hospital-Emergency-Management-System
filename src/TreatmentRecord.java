/**
 * TreatmentRecord.java
 * Details of one treatment that has already been carried out.
 */
public class TreatmentRecord {

    private int patientId;
    private String patientName;
    private String diagnosis;
    private String doctorName;
    private String treatmentDate;

    public TreatmentRecord(int patientId, String patientName, String diagnosis,
                            String doctorName, String treatmentDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.treatmentDate = treatmentDate;
    }

    @Override
    public String toString() {
        return String.format(
            "Patient %-5d (%-18s) | Diagnosis: %-16s | Doctor: %-14s | Date: %s",
            patientId, patientName, diagnosis, doctorName, treatmentDate
        );
    }
}
