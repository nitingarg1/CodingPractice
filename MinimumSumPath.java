import sun.java2d.opengl.OGLRenderQueue;

import java.util.Arrays;

public class MinimumSumPath {
    public static void main(String[] args) {
        System.out.println(new MinimumSumPath().minPathSum2(new int [][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    int minPath=Integer.MAX_VALUE;
//    public int minPathSum(int[][] grid) {
//    if(grid==null)
//        minPath=0;
//    minPath(grid,0,0 ,0);
//    return minPath;
//    }

//    public void minPath(int[][]grid,int row, int col, int intermidatePathSum){
//        if(row>=grid.length || col>=grid[0].length)
//            return;
//        if(row==grid.length-1 && col==grid[0].length-1){
//            intermidatePathSum=intermidatePathSum+grid[row][col];
//            minPath=Math.min(minPath,intermidatePathSum);
//        }
//        minPath(grid,row+1,col,intermidatePathSum+grid[row][col]);
//        minPath(grid,row,col+1 ,intermidatePathSum+grid[row][col]);
//    }

    public int minPathSum2(int[][] grid) {
        if(grid==null)
            minPath=0;
        int cache[][] = new int[grid.length][grid[0].length];
        for(int[] eachRow:cache){
            Arrays.fill(eachRow,Integer.MAX_VALUE);
        }
        cache[0][0] =minPath(grid,0,0 , cache);
        return cache[0][0];
    }
    public int minPath(int[][]grid,int row, int col, int cache[][]){
        if(row>=grid.length || col>=grid[0].length)
            return Integer.MAX_VALUE;
        if(row==grid.length-1 && col==grid[0].length-1){
            cache[row][col]=grid[row][col];
        }
        if(cache[row][col]< Integer.MAX_VALUE){
            return cache[row][col];
        }
        int minPath = Math.min(minPath(grid,row+1,col,cache),
                minPath(grid,row,col+1 ,cache ));
        cache[row][col] = grid[row][col]+minPath;
        return cache[row][col];
    }

}
