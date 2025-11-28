package com.mycompany.lab9;
import java.util.List;

public class BoxChecker implements Checker {
    private int[][] board;
    private int index;
    private List<String> error;

    public BoxChecker(int[][] board, int index,List<String> error) {
        this.board = board;
        this.index = index;
        this.error = error;
    }
    
    public void check()
    {
     SequentialChecker.checkOneBox(board,index,error);   
    }
}
