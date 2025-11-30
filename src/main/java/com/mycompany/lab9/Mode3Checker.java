
package com.mycompany.lab9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Mode3Checker {
    
    public static void run(int[][] board) {
        List<String> rerrors = Collections.synchronizedList(new ArrayList<>());
        List<String> cerrors = Collections.synchronizedList(new ArrayList<>());
        List<String> berrors = Collections.synchronizedList(new ArrayList<>());

        
        Thread rowThread = new Thread(() -> SequentialChecker.checkRows(board, rerrors));
        Thread colThread = new Thread(() -> SequentialChecker.checkCols(board, cerrors));
        Thread boxThread = new Thread(() -> SequentialChecker.checkBoxes(board, berrors));

        
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
}
    

