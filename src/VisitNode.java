/**
 * VisitNode.java
 * One link in a patient's visit history chain.
 */
public class VisitNode {

    private Visit visit;
    private VisitNode next;

    public VisitNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }

    public Visit getVisit()          { return visit; }
    public VisitNode getNext()       { return next; }
    public void setNext(VisitNode n) { this.next = n; }
}
