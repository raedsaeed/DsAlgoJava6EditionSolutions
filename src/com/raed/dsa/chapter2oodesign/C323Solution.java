package com.raed.dsa.chapter2oodesign;

import java.util.Random;

/**
 * Created by Raed Saeed on 8/23/2021
 **/

/*
Suppose you are designing a multiplayer game that has n ≥ 1000 players, numbered
1 to n, interacting in an enchanted forest. The winner of this game is the
first player who can meet all the other players at least once (ties are allowed).
Assuming that there is a method meet(i, j), which is called each time a player i
meets a player j (with i != j), describe a way to keep track of the pairs of meeting
players and who is the winner.
 */
public class C323Solution {
    public static void main(String[] args) {
        Random random = new Random(10);
        int playerSize = 10;
        MultiPlayerGame game = new MultiPlayerGame(playerSize);
        int playerId = random.nextInt(playerSize);
        for (int i = 0; i < playerSize - 1; i++) {
            game.meet(playerId, i);
        }
    }

    public static class Player {
        public int playerId;
        public int playerSizes = 0;
        public int[] playersIds;

        public Player(int playerId, int numOfPlayers) {
            this.playerId = playerId;
            this.playersIds = new int[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++) {
                playersIds[i] = -1;
            }
        }

        public void meet(int otherPlayerId) {
            for (int playersId : playersIds) {
                if (otherPlayerId == playersId) return;
            }

            for (int i = 0; i < playersIds.length; i++) {
                if (playersIds[i] == -1) {
                    playersIds[i] = otherPlayerId;
                    playerSizes++;
                    return;
                }
            }
        }
    }


    public static class MultiPlayerGame {
        public int size;
        public Player[] players;

        public MultiPlayerGame(int size) {
            if (size > 1) {
                this.size = size;
                this.players = new Player[size];
                for (int i = 0; i < size; i++) {
                    players[i] = new Player(i, size - 1);
                }
            } else {
                throw new IllegalArgumentException("Number of players should be greater than 1");
            }
        }

        public void meet(int firstPlayer, int secondPlayer) {
            if (firstPlayer > 0 && firstPlayer < size || secondPlayer > 0 && secondPlayer < size) {
                players[firstPlayer].meet(secondPlayer);
                checkWinner(firstPlayer);
            } else {
                System.out.println("Invalid player id");
            }
        }

        private void checkWinner(int playerId) {
            if (players[playerId].playerSizes == size - 1) {
                System.out.println("Player " + playerId + " Won the game !!");
            }
        }
    }
}
