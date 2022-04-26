import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePathsWithObstacles(new int [][] {{0,0,0},{0,1,0},{0,0,0}} ));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int [] eachRow : cache){
            Arrays.fill(eachRow,-1);
        }

        int uniqueCount=0;
        if(obstacleGrid==null || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;
        uniqueCount = uniquePathsWithObstacles(obstacleGrid,0,0,cache);
    return uniqueCount;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid , int row, int col,int[][] cache){
        if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1){
            cache[row][col]=1;
            return 1;
        }
        if(row>=obstacleGrid.length || col>=obstacleGrid[0].length)
            return 0;
        if(obstacleGrid[row][col]==1) {
            cache[row][col]=0;
            return 0;
        }
        if(cache[row][col]!=-1)
            return cache[row][col];
        cache[row][col] = uniquePathsWithObstacles(obstacleGrid,row+1,col,cache) +uniquePathsWithObstacles(obstacleGrid,row,col+1,cache);
        return cache[row][col];
    }
}
