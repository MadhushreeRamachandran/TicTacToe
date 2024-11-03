# Tic-Tac-Toe Game

A simple yet engaging Tic-Tac-Toe game developed in Java using the Swing framework. This application allows two players to compete, displaying current player turns, identifying the winner, and enabling game reset functionality.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Classes and Components](#classes-and-components)
- [Gameplay Details](#gameplay-details)
- [Code Structure and Explanation](#code-structure-and-explanation)
- [Screenshots](#screenshots)
- [Acknowledgments](#acknowledgments)

---

## Overview
This Tic-Tac-Toe application is a graphical version of the classic game where two players, **Player X** and **Player O**, take turns marking spaces in a 3×3 grid. The game highlights the current player, checks for winning conditions, and displays the winner or tie. It also provides a **Restart** button to reset the game.

---

## Features
- **Interactive UI**: Simple GUI with a 3x3 grid for playing Tic-Tac-Toe.
- **Dynamic Turn Display**: Shows the current player’s turn.
- **Winner Detection**: Highlights the winning combination and displays the winner's name.
- **Tie Condition**: Detects and displays a tie when all tiles are filled with no winner.
- **Restart Game**: Allows players to reset the game and play again.

---

## Getting Started
To run this project locally, you need to have Java installed.

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/TicTacToe.git
   
2. **Compile and run the project**
   ```bash
   javac TicTacToe.java
   java TicTacToe

## Classes and Components

**Main Class- TicTacToe**

The TicTacToe class is the main class of this project, which sets up the JFrame, JPanel, JLabels, and JButtons to create the UI. It includes methods for handling game logic, checking for winners, and resetting the game.

### Key Components
- **`JFrame frame`**: Main window for the application.
- **`JPanel textPanel`**: Panel at the top to show current player and restart button.
- **`JLabel textLabel`**: Label that displays the current player’s turn.
- **`JPanel boardPanel`**: Panel that holds the 3x3 grid of buttons representing the game board.
- **`JButton[][] board`**: 2D array of buttons, each representing a tile on the Tic-Tac-Toe board.
- **`JButton restartButton`**: Button to restart the game.

## Gameplay Details

### Player Initialization
When the game starts, both players are prompted to enter their names via dialog boxes. If no name is entered, the game terminates.

### Player Turns
- **Current Player Tracking**: `currentPlayer` and `currentPlayerName` manage whose turn it is.
- **Dynamic Display**: `textLabel` shows the name of the current player to make the game more engaging.

### Winning and Tie Conditions
- **Winner Detection**: Horizontal, vertical, and diagonal lines are checked after each move to determine if a player has won.
- **Tie Detection**: When all tiles are filled without a winner, the game announces a tie.

### Game Reset
The `resetGame()` method clears the board and resets the game state, allowing players to play again.







