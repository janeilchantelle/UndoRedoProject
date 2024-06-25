package DoubleLinkedList;

public class UndoRedoManager<T> {

    // Inner class representing a node in the doubly linked list
    private class Node {
        private T state;     // State stored in this node
        private Node prev;   // Reference to the previous node
        private Node next;   // Reference to the next node

        // Constructor to initialize a node with a given state
        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;  // Reference to the current state node

    // Method to perform undo operation
    public T undo() {
        // Check if there is no current state to undo
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }

        // Get the previous state
        Node previousState = currentState.prev;
        // If previous state is null, it means we have reached the initial state
        if (previousState == null) {
            System.out.println("Reached the initial state");
            return null;
        } else {
            // Move current state to the previous state
            currentState = previousState;
        }
        return currentState.state;  // Return the state of the current node after undo
    }

    // Method to perform redo operation
    public T redo() {
        // Check if there is no current state or if there is no next state to redo
        if (currentState == null || currentState.next == null) {
            System.out.println("No state to redo");  // Output message indicating no state to redo
            return null;
        }

        currentState = currentState.next;  // Move current state to the next state
        return currentState.state;  // Return the state of the current node after redo
    }

    // Method to perform an action and create a new state
    public void performAction(T newState) {
        Node newNode = new Node(newState);

        newNode.prev = currentState;
        newNode.next = null;

        if (currentState != null) {
            currentState.next = newNode;
        }

        currentState = newNode;
    }

    // Main method to test the UndoRedoManager class
    public static void main(String[] args) {
        // Create an instance of UndoRedoManager for managing String states
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();

        // Actions to create different states
        undoRedoManager.performAction("State 1");
        undoRedoManager.performAction("State 2");
        undoRedoManager.performAction("State 3");
        undoRedoManager.performAction("State 4");
        undoRedoManager.performAction("State 5");

        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 5

        // Undo operations
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 4
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 3
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 2

        // Redo operations
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 3
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 4
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state); // State 5

        // Attempt to redo when no more states are available
        undoRedoManager.redo(); // No state to redo
    }
}
