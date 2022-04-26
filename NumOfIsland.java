import javax.print.DocFlavor;

public class NumOfIsland {

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int numOfIsland=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numOfIsland++;
                    numOfIsland(grid,i,j);
                }
            }
        }
        return numOfIsland;
    }

    public void numOfIsland(char[][] grid, int r, int c){
        int maxR=grid.length-1;
        int maxC = grid[0].length-1;

        if(r<0 || c<0 || r>maxR || c>maxC || grid[r][c]=='0')
            return;
        grid[r][c]='0';
        numOfIsland(grid,r+1,c);
        numOfIsland(grid,r-1,c);
        numOfIsland(grid,r,c+1);
        numOfIsland(grid,r,c-1);

    }
}
