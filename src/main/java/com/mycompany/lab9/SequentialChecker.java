package com.mycompany.lab9;
import java.util.ArrayList;
import java.util.List;


public class SequentialChecker {
     public static void run(int[][] board) {
        List<String> rerrors = new ArrayList<>();
         List<String> cerrors = new ArrayList<>();
          List<String> berrors = new ArrayList<>();

        checkRows(board, rerrors);
        checkCols(board, cerrors);
        checkBoxes(board, berrors);

        if (rerrors.isEmpty()&&cerrors.isEmpty()&&berrors.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (String e : rerrors)
                System.out.println(e);
            System.out.println("---------------------");
            
            for (String e : cerrors)
                System.out.println(e);
            System.out.println("---------------------");
            
            for (String e : berrors)
                System.out.println(e);
            
        }
    }
 
     public static void checkOneRow(int[][] board, int r, List<String> errors) {
    // map number -> list of positions
    List<Integer>[] positions = new ArrayList[10];
    for (int i = 1; i <= 9; i++) positions[i] = new ArrayList<>();

    for (int c = 0; c < 9; c++) {
        int val = board[r][c];
        positions[val].add(c + 1); // store column index (1-based)
    }

    for (int num = 1; num <= 9; num++) {
        if (positions[num].size() > 1) {
            errors.add("ROW " + (r + 1) + ", #" + num + ", " + positions[num]);
        }
    }
}

     public static void checkOneCol(int[][] board, int c, List<String> errors) {
    List<Integer>[] positions = new ArrayList[10];
    for (int i = 1; i <= 9; i++) positions[i] = new ArrayList<>();

    for (int r = 0; r < 9; r++) {
        int val = board[r][c];
        positions[val].add(r + 1); // store row index (1-based)
    }

    for (int num = 1; num <= 9; num++) {
        if (positions[num].size() > 1) {
            errors.add("COL " + (c + 1) + ", #" + num + ", " + positions[num]);
        }
    }
}

     public static void checkOneBox(int[][] board, int b, List<String> errors) {
    List<Integer>[] positions = new ArrayList[10];
    for (int i = 1; i <= 9; i++) positions[i] = new ArrayList<>();

    int br = b / 3;
    int bc = b % 3;

    int index = 1;
    for (int r = br * 3; r < br * 3 + 3; r++) {
        for (int c = bc * 3; c < bc * 3 + 3; c++) {
            int val = board[r][c];
            positions[val].add(index); // store position inside box (1–9)
            index++;
        }
    }

    for (int num = 1; num <= 9; num++) {
        if (positions[num].size() > 1) {
            errors.add("BOX " + (b + 1) + ", #" + num + ", " + positions[num]);
        }
    }
}

     
    public static void checkRows(int[][] board, List<String> errors) {

        for (int r = 0; r < 9; r++) 
        checkOneRow(board, r, errors);
    
    }

    public static void checkCols(int[][] board, List<String> errors) {


         for (int c = 0; c < 9; c++) 
        checkOneCol(board, c, errors);
    
    }

    public static void checkBoxes(int[][] board,List<String> errors) {


      for (int b = 0; b < 9; b++) 
        checkOneBox(board, b, errors);
}
}
