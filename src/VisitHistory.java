/**
 * VisitHistory.java
 * A hand-rolled singly linked list that stores one patient's visits
 * in the order they happened.
 */
public class VisitHistory {

    private VisitNode head;


    // ============================================================
    // IS EMPTY
    // ============================================================

    public boolean isEmpty() {
        return head == null;
    }


    // ============================================================
    // ADD VISIT
    // ============================================================

    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        VisitNode walker = head;

        while (walker.getNext() != null) {
            walker = walker.getNext();
        }

        walker.setNext(newNode);
    }


    // ============================================================
    // SEARCH VISIT
    // ============================================================

    public Visit searchVisit(int visitId) {

        VisitNode walker = head;

        while (walker != null) {

            if (walker.getVisit().getVisitId() == visitId) {
                return walker.getVisit();
            }

            walker = walker.getNext();
        }

        return null;
    }


    // ============================================================
    // REMOVE VISIT
    // ============================================================

    /**
     * Removes a visit by ID. Covers the empty-list case, removing
     * the head node, removing anywhere further down the list, and
     * the not-found case.
     */
    public void removeVisit(int visitId) {

        if (isEmpty()) {
            System.out.println("This patient doesn't have any visit history yet.");
            return;
        }

        if (head.getVisit().getVisitId() == visitId) {

            head = head.getNext();
            System.out.println("Visit " + visitId + " has been removed.");
            return;
        }

        VisitNode previous = head;
        VisitNode current = head.getNext();

        while (current != null) {

            if (current.getVisit().getVisitId() == visitId) {

                previous.setNext(current.getNext());
                System.out.println("Visit " + visitId + " has been removed.");
                return;
            }

            previous = current;
            current = current.getNext();
        }

        System.out.println("No visit with ID " + visitId + " was found for this patient.");
    }


    // ============================================================
    // DISPLAY
    // ============================================================

    public void display() {

        if (isEmpty()) {
            System.out.println("This patient doesn't have any visit history yet.");
            return;
        }

        System.out.println("\nVisit history:");

        VisitNode walker = head;

        while (walker != null) {

            System.out.println(walker.getVisit());
            walker = walker.getNext();
        }
    }
}
