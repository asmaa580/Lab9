
package com.mycompany.lab9;
import java.util.List;

public class RowChecker implements Checker {
    
    private int[][] board;
    private int index;
    private List<String> error;

    public RowChecker(int[][] board, int index, List<String> error) {
        this.board = board;
        this.index = index;
        this.error = error;
    }
    
    public void check()
    {
     SequentialChecker.checkOneRow(board,index,error);   
    }
}
