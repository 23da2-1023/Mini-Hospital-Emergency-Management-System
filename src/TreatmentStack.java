/**
 * TreatmentStack.java
 * A hand-rolled LIFO stack that tracks completed treatments,
 * most recent one on top.
 */
public class TreatmentStack {

    private StackNode top;


    // ============================================================
    // IS EMPTY
    // ============================================================

    public boolean isEmpty() {
        return top == null;
    }


    // ============================================================
    // PUSH
    // ============================================================

    public void push(TreatmentRecord record) {

        StackNode newNode = new StackNode(record);
        newNode.setNext(top);
        top = newNode;
    }


    // ============================================================
    // POP
    // ============================================================

    public TreatmentRecord pop() {

        if (isEmpty()) {
            System.out.println(
                "No treatment records to remove - the history is empty."
            );
            return null;
        }

        TreatmentRecord record = top.getRecord();
        top = top.getNext();

        return record;
    }


    // ============================================================
    // DISPLAY
    // ============================================================

    public void display() {

        if (isEmpty()) {
            System.out.println("No treatments have been recorded yet.");
            return;
        }

        System.out.println("\nTreatment history (most recent on top):");

        StackNode walker = top;

        while (walker != null) {

            System.out.println(walker.getRecord());
            walker = walker.getNext();
        }
    }
}
