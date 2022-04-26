import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        NQueen sol = new NQueen();
        System.out.println(sol.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> out = new ArrayList<>();
        for (char[] element : board) {
            Arrays.fill(element, '.');
        }
        solveNQueens(board, out, 0);
        return out;
    }

    public void solveNQueens(char[][] board, List<List<String>> out, int row) {
    if(row>=board.length){
        out.add(convertBoard(board));
        return ;
    }
        for (int j=0;j<board.length;j++){
            if(validateSelection(board,row,j)){
                board[row][j]='Q';
                solveNQueens(board,out,row+1);
                board[row][j]='.';
            }
        }

    }

    public boolean validateSelection(char[][]board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')
                return false;
        }
        //check for diagonal
        for(int i=1;i<=row;i++){
            if((col-i)>=0 && board[row-i][col-i]=='Q')
                return false;
            if((col+i)<board.length && board[row-i][col+i]=='Q')
                return false;
        }
        return true;
    }

    public List<String> convertBoard(char[][]board){
        List<String> out = new ArrayList<>();
        for(char[] single:board){
            StringBuilder s = new StringBuilder();
            for (char c: single){
                s.append(c);
            }
            out.add(s.toString());
        }
        return out;
    }

}

