package com.mycompany.lab9;
import java.util.Scanner;

public class Lab9 {

    public static void main(String[] args) {
         
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter CSV file path: ");
//        String filePath = sc.nextLine();
//
//        System.out.print("Enter mode (0, 3, or 27): ");
//        int mode = sc.nextInt();

        String filePath=args[0];
        int mode=Integer.parseInt(args[1]);

        
        int[][] board = CSVLoader.loadBoard(filePath);

        
        if (mode == 0) {
            SequentialChecker.run(board);
        } 
        else if (mode == 3) {
            Mode3Checker.run(board);
        } 
        else if (mode == 27) {
            Mode27Checker.run(board);
        } 
        else {
            System.out.println("Invalid mode. Choose 0, 3, or 27.");
        }
    
    }
}
