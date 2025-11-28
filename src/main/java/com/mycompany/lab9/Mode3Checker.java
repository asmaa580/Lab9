
package com.mycompany.lab9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Mode3Checker {
    
    public static void run(int[][] board) {
        List<String> errors = Collections.synchronizedList(new ArrayList<>());

        
        Thread rowThread = new Thread(() -> SequentialChecker.checkRows(board, errors));
        Thread colThread = new Thread(() -> SequentialChecker.checkCols(board, errors));
        Thread boxThread = new Thread(() -> SequentialChecker.checkBoxes(board, errors));

        
        rowThread.start();
        colThread.start();
        boxThread.start();

       
        try {
            rowThread.join();
            colThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        if (errors.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            for (String e : errors) {
                if (e != null && !e.isEmpty()) {
                    System.out.println(e);
                }
            }
        }
    }
}
    

