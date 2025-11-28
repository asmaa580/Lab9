/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class SequentialChecker {
     public static void run(int[][] board) {
        List<String> errors = new ArrayList<>();

        checkRows(board, errors);
        checkCols(board, errors);
        checkBoxes(board, errors);

        if (errors.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (String e : errors)
                System.out.println(e);
        }
    }

    // -----------------------------
    // CHECK ROWS
    // -----------------------------
    public static void checkRows(int[][] board, List<String> errors) {

        for (int r = 0; r < 9; r++) {
            int[] count = new int[10];

            for (int c = 0; c < 9; c++) {
                int value = board[r][c];
                count[value]++;
            }

            for (int num = 1; num <= 9; num++) {
                if (count[num] > 1) {
                    errors.add("ROW " + (r+1) + " has duplicate " + num);
                }
            }
        }
    }

    // -----------------------------
    // CHECK COLUMNS
    // -----------------------------
    public static void checkCols(int[][] board, List<String> errors) {

        for (int c = 0; c < 9; c++) {
            int[] count = new int[10];

            for (int r = 0; r < 9; r++) {
                int value = board[r][c];
                count[value]++;
            }

            for (int num = 1; num <= 9; num++) {
                if (count[num] > 1) {
                    errors.add("COL " + (c+1) + " has duplicate " + num);
                }
            }
        }
    }

    // -----------------------------
    // CHECK 3×3 BOXES
    // -----------------------------
    public static void checkBoxes(int[][] board, List<String> errors) {

        int boxIndex = 1;

        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {

                int[] count = new int[10];

                for (int r = br * 3; r < br * 3 + 3; r++) {
                    for (int c = bc * 3; c < bc * 3 + 3; c++) {
                        int value = board[r][c];
                        count[value]++;
                    }
                }

                for (int num = 1; num <= 9; num++) {
                    if (count[num] > 1) {
                        errors.add("BOX " + (boxIndex) + " has duplicate " + num);
                    }
                }

                boxIndex++;
            }
        }
    }
}
