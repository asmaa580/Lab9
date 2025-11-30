
package com.mycompany.lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mode27Checker {
     public static void run(int[][] board) {

        List<String> rerrors = Collections.synchronizedList(new ArrayList<>());
        List<String> cerrors = Collections.synchronizedList(new ArrayList<>());
        List<String> berrors = Collections.synchronizedList(new ArrayList<>());
        Thread[] threads = new Thread[27];
        int index = 0;

        // 9 row checkers
        for (int r = 0; r < 9; r++) {
            Checker checker = CheckerFactory.createChecker("ROW", board,r, rerrors);
            threads[index++] = new Thread(() -> checker.check());
        }

        // 9 column checkers
        for (int c = 0; c < 9; c++) {
            Checker checker = CheckerFactory.createChecker("COL", board, c, cerrors);
            threads[index++] = new Thread(() -> checker.check());
        }

        // 9 box checkers
        for (int b = 0; b < 9; b++) {
            Checker checker = CheckerFactory.createChecker("BOX", board, b, berrors);
            threads[index++] = new Thread(() -> checker.check());
        }

        // Start all 27 threads
        for (Thread t : threads) t.start();

        // Wait for all 27 threads to finish
        try {
            for (Thread t : threads) t.join();
        } catch (Exception ignored) {}

        // Print output
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
