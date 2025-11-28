/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
