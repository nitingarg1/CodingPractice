import java.util.Arrays;

public class DungeonProblem {
    public static void main(String[] args) {
//        System.out.println(new DungeonProblem().calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
        System.out.println(new DungeonProblem().calculateMinimumHP(new int[][]{{-3,5}}));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int [][] cachce = new int[dungeon.length][dungeon[0].length];
        for(int[] eachRow : cachce){
            Arrays.fill(eachRow,Integer.MIN_VALUE);
        }
        calculateMinimumHP(dungeon,cachce,0,0);
        return Math.abs(cachce[0][0]>0?0:cachce[0][0])+1;

    }

    public int calculateMinimumHP(int[][] dungeon,int[][] cache,int row, int col) {
        if(row>=dungeon.length || col>=dungeon[0].length)
            return Integer.MIN_VALUE;
        if(row==dungeon.length-1 && col==dungeon[0].length-1)
            cache[row][col]= dungeon[row][col];
        if(cache[row][col]>Integer.MIN_VALUE)
            return cache[row][col];
        int downstreamMaxVal = Math.max(calculateMinimumHP(dungeon,cache,row,col+1), calculateMinimumHP(dungeon,cache,row+1,col))+dungeon[row][col];
        cache[row][col] = downstreamMaxVal >0?0:downstreamMaxVal;
        return cache[row][col];
    }
}
