package com.raed.dsa.chapter2.impl;

import java.util.Scanner;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class TicToc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player one : ");
        String playerOne = scanner.nextLine();
        System.out.println("Player Two : ");
        String playerTwo = scanner.nextLine();
        TicGame game = new TicGame(playerOne, playerTwo);
        game.startGame();
    }

   public static class TicGame {
        private final int[][] board;
        private final String playerOne;
        private final String playerTwo;
        private final Character playerOneSymbol;
        private final Character playerTwoSymbol;

        private int currentPlayer = -1; // -1 for player one, 1 for player two
        private int numberOfTrying = 0;

        public TicGame(String playerOne, String playerTwo) {
            this(playerOne, playerTwo, 'X', 'O');
        }

        public TicGame(String playerOne, String playerTwo, Character playerOneSymbol, Character playerTwoSymbol) {
            this.playerOne = playerOne;
            this.playerTwo = playerTwo;
            this.playerOneSymbol = playerOneSymbol;
            this.playerTwoSymbol = playerTwoSymbol;
            board = new int[3][3];
        }

        public void startGame() {
            play();
        }

        private void play() {
            String player = getPlayer();
            System.out.print(player + " Enter your position : ");
            int position = Integer.parseInt(new Scanner(System.in).nextLine());
            if (position < 1 || position > 9) {
                System.out.println("Enter valid position from 1 to 9");
                play();
            } else {
                setPlayerOnPosition(currentPlayer, position);
                drawGame();
                if (isWining()) {
                    System.out.println("Congratulations " + getPlayer() + " won the game");
                } else if (numberOfTrying == 9) {
                    System.out.println("تعادل");
                } else {
                    currentPlayer *= -1;
                    play();
                }
            }
        }

        private String getPlayer() {
            return currentPlayer == -1 ? playerOne : playerTwo;
        }

        private void drawGame() {
            numberOfTrying++;
            StringBuilder builder = new StringBuilder();
            for (int[] row : board) {
                for (int j = 0; j < row.length; j++) {
                    CharSequence divider = j < 2 ? "|" : "";
                    builder.append(getSymbol(row[j]))
                            .append(divider);
                }
                builder.append("\n");
            }
            System.out.println(builder);
        }

        private Character getSymbol(int state) {
            return switch (state) {
                case -1 -> playerOneSymbol;
                case 1 -> playerTwoSymbol;
                default -> '-';
            };
        }

        private void setPlayerOnPosition(int player, int position) {
            int[] row = board[getCorrespondingRow(position)];
            row[getCorrespondingColumn(position)] = player;
            board[getCorrespondingRow(position)] = row;
        }

        private int getCorrespondingColumn(int position) {
            return (position - 1) % 3;
        }

        private int getCorrespondingRow(int position) {
            return (position - 1) / 3;
        }

        private boolean isWining() {
            return board[0][0] + board[0][1] + board[0][2] == 3 * currentPlayer ||
                    board[1][0] + board[1][1] + board[1][2] == 3 * currentPlayer ||
                    board[2][0] + board[2][1] + board[2][2] == 3 * currentPlayer ||

                    board[0][0] + board[1][0] + board[2][0] == 3 * currentPlayer ||
                    board[0][1] + board[1][1] + board[2][1] == 3 * currentPlayer ||
                    board[0][2] + board[1][2] + board[2][2] == 3 * currentPlayer ||

                    board[0][0] + board[1][1] + board[2][2] == 3 * currentPlayer ||
                    board[0][2] + board[1][1] + board[2][0] == 3 * currentPlayer;
        }
    }
}
