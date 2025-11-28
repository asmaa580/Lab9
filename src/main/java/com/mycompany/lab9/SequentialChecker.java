package com.mycompany.lab9;
import java.util.ArrayList;
import java.util.List;


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
     public static void checkOneRow(int[][] board, int r, List<String> errors) {
        int[] count = new int[10];

        for (int c = 0; c < 9; c++) 
            count[board[r][c]]++;

        for (int num = 1; num <= 9; num++) 
            if (count[num] > 1) 
                errors.add("ROW " + (r + 1) + " duplicate " + num);

    }
     
     public static void checkOneCol(int[][] board,int c,List<String> errors)
     {
         int[] count=new int[10];
         for(int r=0;r<9;r++)
             count [board[r][c]]++;
         
         for(int num=1;num<=9;num++)
             if (count[num]>1)
                 errors.add("COL "+(c+1)+"dublicate "+num);
                 
     }
     
     public static void checkOneBox(int[][] board,int b,List<String> errors)
     {
         int[] count=new int[10];
         int br = b / 3;   // box row
        int bc = b% 3;   // box column

        for (int r = br * 3; r < br * 3 + 3; r++) 
            for (int c = bc * 3; c < bc * 3 + 3; c++) 
                count[board[r][c]]++;
            
        

        for (int num = 1; num <= 9; num++) 
            if (count[num] > 1) 
                errors.add("BOX " + (b + 1) + " duplicate " + num);
            
     }

     
    public static void checkRows(int[][] board, List<String> errors) {

        for (int r = 0; r < 9; r++) 
        checkOneRow(board, r, errors);
    
    }

   
    public static void checkCols(int[][] board,List<String> errors) {

         for (int c = 0; c < 9; c++) 
        checkOneCol(board, c, errors);
    
    }

   
    public static void checkBoxes(int[][] board,List<String> errors) {

      for (int b = 0; b < 9; b++) 
        checkOneBox(board, b, errors);
}
}
