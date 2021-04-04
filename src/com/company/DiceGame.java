package com.company;

import java.util.Scanner;

/*
Реализуйте игру в кости. Играют N игроков (компьютер в списке последний).
Подкидываются одновременно К кубиков. Выигрывает тот, у кого большая
сумма очков. Кто выиграл, тот и кидает первым в следующем кону. Игра идет
до 7 выигрышей. Начинаете игру Вы
*/
public class DiceGame {
    private int N;
    private int K;
    private Player[] players;

    public DiceGame(int N, int K) {
        this.N = N;
        this.K = K;
        players = new Player[N];
        for (int i = 0; i < players.length - 1; i++) {
            players[i] = new Player(String.valueOf(i + 1));
        }
        players[players.length - 1] = new Player(String.valueOf("Computer"));
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    //Метод самой игры
    public void game() {
        GameTriggers gameTriggers = new GameTriggers(this);
        int rounds = 1;
        while (true) {
            System.out.printf("Round %d\n", rounds++);
            for (Player p : players) {
                System.out.printf("player %s\n", p.getName());
                p.throwDice(K);
                System.out.println();
            }
            players[gameTriggers.winner()].setWins();
            this.setPlayers(gameTriggers.sortBeforeNewRound(gameTriggers.winner()));
            if (gameTriggers.maxWins()[1].equals("7")) {
                System.out.printf("Player %s won!", gameTriggers.maxWins()[0]);
                break;
            }
        }
    }

    static class GameTriggers {
        private DiceGame diceGame;

        public GameTriggers(DiceGame diceGame) {
            this.diceGame = diceGame;
        }

        //Возвращаем индекс победителя раунда
        public int winner() {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int i = 0; i < diceGame.players.length; i++) {
                if (diceGame.players[i].getRoundPoints() > max) {
                    max = diceGame.players[i].getRoundPoints();
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        //Сортируем массив игроков так, чтобы победитель раунда бросал первым в следующем раунде
        public Player[] sortBeforeNewRound(int winnerIndex) {
            Player winner = diceGame.players[winnerIndex];
            for (int i = winnerIndex; i > 0; i--) {
                diceGame.players[i] = diceGame.players[i - 1];
            }
            diceGame.players[0] = winner;
            return diceGame.players;
        }

        //Возвращаем имя выигрывающего и количество побед
        public String[] maxWins() {
            int max = Integer.MIN_VALUE;
            String nameWinner = "";
            for (Player p : diceGame.players) {
                if (p.getWins() > max) {
                    max = p.getWins();
                    nameWinner = p.getName();
                }
            }
            return new String[]{nameWinner, String.valueOf(max)};
        }
    }
}
