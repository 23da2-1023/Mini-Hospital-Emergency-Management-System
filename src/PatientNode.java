/**
 * PatientNode.java
 * One node inside the Patient BST.
 */
public class PatientNode {

    private Patient patient;
    private PatientNode left;    // smaller patient IDs live here
    private PatientNode right;   // larger patient IDs live here

    public PatientNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }

    public Patient getPatient() {
        return patient;
    }

    // Used by PatientBST.delete() when copying the successor up.
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientNode getLeft() {
        return left;
    }

    public void setLeft(PatientNode left) {
        this.left = left;
    }

    public PatientNode getRight() {
        return right;
    }

    public void setRight(PatientNode right) {
        this.right = right;
    }
}
