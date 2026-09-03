/**
 * QueueNode.java
 * One link in the emergency queue's chain.
 */
public class QueueNode {

    private Patient patient;
    private QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Patient getPatient()      { return patient; }
    public QueueNode getNext()       { return next; }
    public void setNext(QueueNode n) { this.next = n; }
}
