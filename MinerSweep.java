import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MinerSweep {

    public static void main(String[] args) {
//    MinerSweep m = new MinerSweep();
//    char[][] board = m.generateBoard(4,2);
//    boolean [][]evalB = new boolean[4][4];
//    m.printBoard(board);
//    m.clickBoard(board,new int[] {2,0},false,evalB);
//    m.printBoard(board);
      new MinerSweep().updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}},new int []{3,0});
    }

//    public char[][] generateBoard(int n, int m){
//        char[][] board = new char[n][n];
//        Random rand = new Random();
//        for(char[] r:board)
//            Arrays.fill(r,'-');
//
//
//        while(m>0){
//            int r = rand.nextInt(n-1);
//            int c = rand.nextInt(n-1);
//            if(board[r][c]=='-'){
//                board[r][c]='M';
//                m--;
//            }
//        }
//    return board;
//    }
//
//    public void printBoard(char[][] board){
//        for(char[] r:board)
//            System.out.println(Arrays.toString(r));
//    }
//
//    public void clickBoard(char[][] board, int[] click, boolean cascade,boolean [][]evalB){
//        if(board[click[0]][click[1]]=='M' && !cascade) {
//            System.out.println("Game Over");
//            return;
//        }
//        if(board[click[0]][click[1]]!='-' ||
//                (click[0] <0 || click[0] >=board.length
//                        ||click[1] <0 || click[1] >=board.length) ||evalB[click[0]][click[1]])
//            return;
//        int [][] direction = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
//        evalB[click[0]][click[1]]=true;
//        int mCount=0;
//        for( int [] dr:direction){
//            if(!(click[0]+dr[0] <0 || click[0]+dr[0] >=board.length
//                    ||click[1]+dr[1] <0 || click[1]+dr[1] >=board.length)){
//                if(board[click[0]+dr[0]][click[1]+dr[1] ]=='M')
//                    mCount++;
//            }
//        }
//
//
//        if(mCount==0) {
//            for (int[] dr : direction) {
//                if (!(click[0] + dr[0] < 0 || click[0] + dr[0] >= board.length
//                        || click[1] + dr[1] < 0 || click[1] + dr[1] >= board.length))
//                    clickBoard(board, new int[]{click[0] + dr[0], click[1] + dr[1]}, true, evalB);
//            }
//        }
//        board[click[0]][click[1]]=Character.forDigit(mCount,10);
//    }

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> clickQueue = new LinkedList<>();
        clickQueue.add(click);
        int[][] dir = new int [][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        while(clickQueue.size()>0){
         int queSize = clickQueue.size();

            while(queSize>0){
            int [] clickPoll= clickQueue.poll();
                queSize--;
            int count=0;
            if(board[clickPoll[0]][clickPoll[1]]=='E'){
                Queue<int[]> temp = new LinkedList<>();
                for(int[] d: dir){
                    if(clickPoll[0]+d[0]>=0 && clickPoll[0]+d[0]<board.length && clickPoll[1]+d[1]>=0 && clickPoll[1]+d[1]<board[0].length){
                     if(board[clickPoll[0]+d[0]][clickPoll[1]+d[1]]=='M'){
                         count++;
                     }else if(board[clickPoll[0]+d[0]][clickPoll[1]+d[1]]=='E')
                         temp.add(new int[]{clickPoll[0]+d[0],clickPoll[1]+d[1]});
                    }
                }
                if(count>0)
                    board[clickPoll[0]][clickPoll[1]]=Character.forDigit(count,10);
                else {
                    board[clickPoll[0]][clickPoll[1]] = 'B';
                    clickQueue.addAll(temp);
                }

            }
            }
        }
return board;
    }
}
