package com.company;

import java.util.Random;

public class Player {
    private String name;
    private int wins;
    private int roundPoints;

    public Player(String name) {
        this.name = name;
        wins = 0;
    }

    //Метод бросания кости K раз
    public void throwDice(int K) {
        Random r = new Random();
        int sum = 0;
        this.setRoundPoints(sum);
        roundPoints = 0;
        for (int i = 0; i < K; i++) {
            int dice = r.nextInt(6) + 1;
            sum += dice;
            System.out.print(dice + " ");
        }
        this.setRoundPoints(sum);
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    public int getRoundPoints() {
        return roundPoints;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }


    public void setWins() {
        this.wins++;
    }
}
