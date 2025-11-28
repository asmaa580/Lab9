/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab9;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Lab9 {

    public static void main(String[] args) {
          // 1. Read arguments
        Scanner sc = new Scanner(System.in);

        // Ask user for file path
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();

        // Ask user for mode
        System.out.print("Enter mode (0, 3, or 27): ");
        int mode = sc.nextInt();
        // 2. Load board
        int[][] board = CSVLoader.loadBoard(filePath);

        // 3. Choose mode
        if (mode == 0) {
            SequentialChecker.run(board);
        } 
        else if (mode == 3) {
            Mode3Checker.run(board);
        } 
       /* else if (mode == 27) {
            Mode27Checker.run(board);
        } */
        else {
            System.out.println("Invalid mode. Choose 0, 3, or 27.");
        }
    
    }
}
