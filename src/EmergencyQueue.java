/**
 * EmergencyQueue.java
 * A hand-rolled FIFO queue that holds patients waiting for emergency care.
 */
public class EmergencyQueue {

    private QueueNode front;   // next patient to be treated
    private QueueNode rear;    // last patient in line


    // ============================================================
    // IS EMPTY
    // ============================================================

    public boolean isEmpty() {
        return front == null;
    }


    // ============================================================
    // ENQUEUE
    // ============================================================

    /**
     * Adds a patient to the back of the line.
     */
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (isEmpty()) {

            front = newNode;
            rear = newNode;

        } else {

            rear.setNext(newNode);
            rear = newNode;
        }
    }


    // ============================================================
    // DEQUEUE
    // ============================================================

    /**
     * Removes and returns the patient at the front of the line.
     */
    public Patient dequeue() {

        if (isEmpty()) {
            System.out.println(
                "There's no one waiting in the emergency queue right now."
            );
            return null;
        }

        Patient nextPatient = front.getPatient();

        front = front.getNext();

        // Queue just became empty, so rear needs to reset too.
        if (front == null) {
            rear = null;
        }

        return nextPatient;
    }


    // ============================================================
    // DISPLAY
    // ============================================================

    public void display() {

        if (isEmpty()) {
            System.out.println("The emergency queue is currently empty.");
            return;
        }

        System.out.println("\nWaiting list (front to back):");

        QueueNode walker = front;

        while (walker != null) {

            System.out.println(walker.getPatient());
            walker = walker.getNext();
        }
    }
}
