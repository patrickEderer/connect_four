package com.company;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int turn = 1;

    public static void main(String[] args) {
        int[][] pos = {{0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}};
        while (win(pos) == 0) {
            draw(pos);
            if (turn == 3) turn = 1;
            if (turn == 1) System.out.println("■'s turn");
            if (turn == 2) System.out.println("□'s turn");
            if (calc(scanner.nextInt(), pos, turn) == 1) turn++;
        }
        if (win(pos) == 1) {
            draw(pos);
            System.out.println("■ won!");
        }
        if (win(pos) == 2) {
            draw(pos);
            System.out.println("□ won!");
        }
    }

    public static void draw(int[][] pos) {
        System.out.println("\n\n\n\n\n+-1---2---3---4---5---6---7-+");


        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 7; x++) {
                if (pos[y][x] == 0) System.out.print("|   ");
                if (pos[y][x] == 1) System.out.print("| ■ ");
                if (pos[y][x] == 2) System.out.print("| □ ");
            }
            System.out.print("|\n+---+---+---+---+---+---+---+\n");
        }
    }

    public static int calc(int x, int[][] pos, int turn) {
        for (int n = 5; n >= 0; n--) {
            if (pos[n][x - 1] == 0) {
                pos[n][x - 1] = turn;
                return 1;
            }
        }
        System.out.println("This column is full!");
        return 0;
    }

    public static int win(int[][] pos) {
        for (int y = 5; y >= 0; y--) {
            for (int x = 0; x < 7; x++) {
                if (pos[y][x] != 0) {
                    if (y >= 3) {
                        if (pos[y][x] == pos[y - 1][x] && pos[y][x] == pos[y - 2][x] && pos[y][x] == pos[y - 3][x])
                            return pos[y][x];
                    }
                    if (x <= 3) {
                        if (pos[y][x] == pos[y][x + 1] && pos[y][x] == pos[y][x + 2] && pos[y][x] == pos[y][x + 3])
                            return pos[y][x];
                    }
                    if (x >= 3 & y >= 3 ) {
                        if (pos[y][x] == pos[y - 1][x - 1] && pos[y][x] == pos[y - 2][x - 2] && pos[y][x] == pos[y - 3][x - 3])
                            return pos[y][x];
                    }
                    if (x <= 3 & y >= 3) {
                        if (pos[y][x] == pos[y - 1][x + 1] && pos[y][x] == pos[y - 2][x + 2] && pos[y][x] == pos[y - 3][x + 3])
                            return pos[y][x];
                    }
                }
            }
        }
        return 0;
    }
}
