public class WordSearch {
    public static void main(String[] args) {
        new WordSearch().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
    }
    public boolean exist(char[][] board, String word) {
    if(word==null || word.length()<1)
        return true;
    boolean[][]boardCache = new boolean[board.length][board[0].length];
     for(int i=0;i<board.length;i++){
         for(int j=0;j<board[0].length;j++){
             if(exist(board,word.toCharArray(),0,i,j,boardCache))
                return true;
         }
     }
    return false;
    }

    public boolean exist(char[][] board, char[] word,int index, int row, int col,boolean[][]boardCache) {
        if(index>=word.length)
            return true;
        if(row>=board.length || row<0 || col >=board[0].length || col<0)
            return false;
        if(board[row][col]!=word[index] || boardCache[row][col])
            return false;
        boardCache[row][col]=true;
        boolean exist= exist(board,word,index+1,row+1,col,boardCache) || exist(board,word,index+1,row-1,col,boardCache)
                || exist(board,word,index+1,row,col+1,boardCache) || exist(board,word,index+1,row,col-1,boardCache);
        boardCache[row][col]=false;
        return exist;
    }
}
