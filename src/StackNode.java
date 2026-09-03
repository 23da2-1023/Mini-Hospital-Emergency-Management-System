/**
 * StackNode.java
 * One link in the treatment stack.
 */
public class StackNode {

    private TreatmentRecord record;
    private StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }

    public TreatmentRecord getRecord() { return record; }
    public StackNode getNext()         { return next; }
    public void setNext(StackNode n)   { this.next = n; }
}
