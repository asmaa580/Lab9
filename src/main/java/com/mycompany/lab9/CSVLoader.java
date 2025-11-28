/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author USER
 */
public class CSVLoader {
     public static int[][] loadBoard(String path) {
        int[][] board = new int[9][9];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            for (int i = 0; i < 9; i++) {
                String line = br.readLine();
                String[] parts = line.split(",");

                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(parts[j]);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return board;
    }
}
