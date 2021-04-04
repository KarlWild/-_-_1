package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Решение квадратных уравнений\n" +
                "2. Игра в кости\n" +
                "3. Адрес человека");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите a, b и c через пробел:");
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                QuadracticEquations quadracticEquations = new QuadracticEquations(a, b, c);
                for (double root : quadracticEquations.roots()) System.out.print(root + " ");
                break;
            case 2:
                System.out.println("Введите N игроков и K кубиков через пробел:");
                int N = sc.nextInt();
                int K = sc.nextInt();
                DiceGame diceGame = new DiceGame(N,K);
                diceGame.game();
                break;
            case 3:
                SearchHumanAddress searchHumanAddress = new SearchHumanAddress();
                searchHumanAddress.Process();
                break;
            default:
                break;
        }
    }
}
