package com.mycompany.lab9;
import java.util.List;

public class CheckerFactory {
    public static Checker createChecker(String type,int[][] board,int index,List<String> error)
    {
        switch(type)
        {
            case "ROW":
                return new RowChecker(board,index,error);
            
            case "COL":
                return new ColChecker(board,index,error);
            
            case "Box":
                return new BoxChecker(board,index,error);
                
            default:
               throw new IllegalArgumentException("Unknown checker type: " + type); 
                          
        }
        
    }
}
