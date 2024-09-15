import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe {
    int boardwidth = 600;
    int boardheight = 700;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();

    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    String playerXName;
    String playerOName;
    String playerX = "X";
    String playerO = "O";
    boolean gameOver = false;
    int turns = 0;

    String currentPlayer;
    String currentPlayerName;

    JButton restartButton = new JButton("Restart");

    TicTacToe() {
        // Get player names
        while (playerXName == null || playerXName.trim().isEmpty()) {
            playerXName = JOptionPane.showInputDialog("Enter name for Player X:");
            if (playerXName == null) {
                JOptionPane.showMessageDialog(frame, "Game cannot start without Player X's name. Exiting game.");
                System.exit(0);
            }
        }
        
        while (playerOName == null || playerOName.trim().isEmpty()) {
            playerOName = JOptionPane.showInputDialog("Enter name for Player O:");
            if (playerOName == null) {
                JOptionPane.showMessageDialog(frame, "Game cannot start without Player O's name. Exiting game.");
                System.exit(0);
            }
        }
    
        currentPlayer = playerX;
        currentPlayerName = playerXName;
    
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText(currentPlayerName + "'s turn");
        textLabel.setOpaque(true);
    
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
    
        restartButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        restartButton.setEnabled(false);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    
        textPanel.add(restartButton, BorderLayout.EAST);
    
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(boardPanel, BorderLayout.CENTER);
    
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.DARK_GRAY);
        boardPanel.setForeground(Color.DARK_GRAY);
    
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);
    
                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Times New Roman ", Font.BOLD, 120));
                tile.setFocusable(false);
    
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
    
                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                currentPlayerName = currentPlayer.equals(playerX) ? playerXName : playerOName;
                                textLabel.setText(currentPlayerName + "'s turn");
                            } else {
                                restartButton.setEnabled(true); 
                            }
                        }
                    }
                });
            }
        }
    }
    

    void checkWinner() {
        // Horizontal check
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText().equals("")) continue;

            if (board[r][0].getText().equals(board[r][1].getText()) && board[r][1].getText().equals(board[r][2].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        // Vertical check
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText().equals("")) continue;
            if (board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        // Diagonal check
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && !board[0][0].getText().equals("")) {
            for (int i = 0; i < 3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }

        // Anti-diagonal check
        if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && !board[0][2].getText().equals("")) {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        // Tie check
        if (turns == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
            restartButton.setEnabled(true);  // Enable the restart button when the game is over
        }
    }

    void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.white);
        textLabel.setText(currentPlayerName + " is the winner");
    }

    void setTie(JButton tile) {
        tile.setForeground(Color.RED);
        tile.setBackground(Color.gray);
        textLabel.setText("TIE !!!");
    }

    void resetGame() {
        gameOver = false;
        turns = 0;
        currentPlayer = playerX;
        currentPlayerName = playerXName;
        textLabel.setText(currentPlayerName + "'s turn");
        restartButton.setEnabled(false);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setBackground(Color.DARK_GRAY);
                board[r][c].setForeground(Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
