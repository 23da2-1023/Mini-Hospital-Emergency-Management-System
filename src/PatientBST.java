/**
 * PatientBST.java
 *
 * Binary search tree that stores every registered patient, keyed by
 * patientId. Smaller IDs sit to the left, larger IDs to the right,
 * which is what makes the in-order traversal come out sorted.
 */
public class PatientBST {

    private PatientNode root;


    // ============================================================
    // INSERT
    // ============================================================

    public void insert(Patient patient) {
        root = insertHelper(root, patient);
    }

    private PatientNode insertHelper(PatientNode node, Patient patient) {

        if (node == null) {
            return new PatientNode(patient);
        }

        int nodeId = node.getPatient().getPatientId();

        if (patient.getPatientId() < nodeId) {

            node.setLeft(insertHelper(node.getLeft(), patient));

        } else if (patient.getPatientId() > nodeId) {

            node.setRight(insertHelper(node.getRight(), patient));

        } else {

            System.out.println(
                "A patient with ID " + patient.getPatientId()
                + " already exists - duplicate entry ignored."
            );
        }

        return node;
    }


    // ============================================================
    // SEARCH
    // ============================================================

    public Patient search(int id) {
        return searchHelper(root, id);
    }

    private Patient searchHelper(PatientNode node, int id) {

        if (node == null) {
            return null;
        }

        int nodeId = node.getPatient().getPatientId();

        if (id == nodeId) {
            return node.getPatient();
        }

        if (id < nodeId) {
            return searchHelper(node.getLeft(), id);
        }

        return searchHelper(node.getRight(), id);
    }


    // ============================================================
    // DELETE
    // ============================================================

    public void delete(int id) {
        root = deleteHelper(root, id);
    }

    /**
     * Standard BST delete with the usual three cases: leaf node,
     * one child, and two children (where we swap in the in-order
     * successor from the right subtree).
     */
    private PatientNode deleteHelper(PatientNode node, int id) {

        if (node == null) {
            System.out.println(
                "Patient with ID " + id + " not found."
            );
            return null;
        }

        int nodeId = node.getPatient().getPatientId();

        if (id < nodeId) {

            node.setLeft(deleteHelper(node.getLeft(), id));
            return node;

        } else if (id > nodeId) {

            node.setRight(deleteHelper(node.getRight(), id));
            return node;
        }

        // Found the node to remove.

        if (node.getLeft() == null) {
            return node.getRight();
        }

        if (node.getRight() == null) {
            return node.getLeft();
        }

        // Two children: pull up the smallest node from the right
        // subtree and delete it from there instead.
        PatientNode successor = findMin(node.getRight());

        node.setPatient(successor.getPatient());

        node.setRight(
            deleteHelper(node.getRight(), successor.getPatient().getPatientId())
        );

        return node;
    }


    // ============================================================
    // FIND MINIMUM
    // ============================================================

    private PatientNode findMin(PatientNode node) {

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }


    // ============================================================
    // IN-ORDER TRAVERSAL
    // ============================================================

    public void displayInOrder() {

        if (root == null) {
            System.out.println("There are no patient records to display yet.");
            return;
        }

        System.out.println("\nRegistered patients (sorted by ID):");
        inOrderHelper(root);
    }

    private void inOrderHelper(PatientNode node) {

        if (node == null) {
            return;
        }

        inOrderHelper(node.getLeft());
        System.out.println(node.getPatient());
        inOrderHelper(node.getRight());
    }
}
