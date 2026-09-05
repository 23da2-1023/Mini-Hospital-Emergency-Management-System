# Mini Hospital Emergency Management System

A menu-driven console application in Java that simulates how a hospital
manages patients, using four manually-implemented data structures.

This project was developed for **CIT300 – Data Structures and Algorithms**
(Individual Mid Assignment) at SLTC Research University.

## Data Structures Used

| Data Structure | Purpose |
|----------------|---------|
| Binary Search Tree (BST) | Stores patient records, keyed by Patient ID |
| Queue (FIFO) | Manages emergency patients waiting for treatment |
| Stack (LIFO) | Stores completed treatment records |
| Singly Linked List | Stores each patient's visit history |

All four structures are implemented manually using classes and nodes.
No Java built-in collections (ArrayList, LinkedList, Stack, etc.) are used
for the required structures.

## Features

- Register, search, delete and display patients (BST, in-order traversal)
- Add and treat emergency patients (Queue, FIFO)
- Record and review completed treatments (Stack, LIFO)
- Add, search, remove and display each patient's visits (Linked List)
- Input validation so the program does not crash on invalid input

## How to Run

The project needs only the Java Development Kit (JDK). No external libraries
or database are required.

```
cd src
javac *.java
java Main
```

The main menu will appear, and any option can be selected by entering its number.

## Project Structure

```
src/
├── Main.java                  # Menu and program control
├── Patient.java               # Patient record (holds its own VisitHistory)
├── PatientNode.java           # BST node
├── PatientBST.java            # Binary Search Tree
├── QueueNode.java             # Queue node
├── EmergencyQueue.java        # Emergency Queue (FIFO)
├── TreatmentRecord.java       # Treatment record data
├── StackNode.java             # Stack node
├── TreatmentStack.java        # Treatment Stack (LIFO)
├── Visit.java                 # Visit data
├── VisitNode.java             # Linked list node
└── VisitHistory.java          # Singly Linked List (visit history)
```

## What I Learned

Through this project, I learned how different data structures can be used to
solve different problems in a hospital management system. I understood how a
BST can efficiently store and search patient records, how a Queue follows FIFO
for emergency patients, and how a Stack follows LIFO for completed treatments.

The most challenging part for me was implementing BST deletion, especially when
a patient node has two children. I also learned how linked structures work by
connecting nodes using references, and how each patient can maintain their own
visit history using a singly linked list.

I also learned the importance of input validation and handling empty structures
so that the program can continue running without crashing. Overall, this project
helped me understand the practical use of data structures rather than only
learning them as theory.

## Author

**M.S. Asmath Shihani**
Bachelor of Applied Information Technology
Faculty of Computing and IT
