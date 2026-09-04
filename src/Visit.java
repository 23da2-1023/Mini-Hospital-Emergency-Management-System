/**
 * Visit.java
 * Details of a single hospital visit for one patient.
 */
public class Visit {

    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public Visit(int visitId, String visitDate, String doctorName,
                 String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getVisitId() {
        return visitId;
    }

    @Override
    public String toString() {
        return String.format(
            "Visit %-3d | Date: %-12s | Doctor: %-14s | Diagnosis: %-16s | Treatment: %s",
            visitId, visitDate, doctorName, diagnosis, treatment
        );
    }
}
