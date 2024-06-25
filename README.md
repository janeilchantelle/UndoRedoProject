
# UndoRedoManager

## Description

`UndoRedoManager` is a Java class that implements a simple undo and redo functionality using a doubly linked list structure.
It allows recording and navigating through different states, supporting undoing and redoing actions.

## Class Structure

The `UndoRedoManager` class consists of:

- **Node Class**: An inner class representing a state in the doubly linked list.
  - `state`: Holds the state information.
  - `prev`: Points to the previous state.
  - `next`: Points to the next state.

- **Fields**:
  - `currentState`: Points to the current state node.

- **Methods**:
  - `performAction(T newState)`: Records a new state and updates the linked list.
  - `undo()`: Moves back to the previous state.
  - `redo()`: Moves forward to the next state.
  - `main(String[] args)`: Contains example usage demonstrating how to perform actions, undo, and redo states.

## Usage

To use the `UndoRedoManager` class:
- Create an instance of `UndoRedoManager`.
- Perform actions using `performAction(newState)`.
- Use `undo()` to go back to previous states.
- Use `redo()` to move forward through undone states.


## Notes

- The `undo()` method moves back to the previous state if available.
- The `redo()` method moves forward to the next state if available.
---

