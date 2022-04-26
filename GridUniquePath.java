import java.util.Arrays;

public class GridUniquePath {
    public static void main(String[] args) {

        System.out.println(new GridUniquePath().uniquePaths(3,7));

    }

    public int uniquePaths(int m, int n) {
        int[][] pathEval = new int [m][n];
        for (int [] arr : pathEval)
          Arrays.fill(arr,-1);
       return evalPath(0,0,pathEval);
    }

    public int evalPath(int r, int c, int[][]pathEval){
        if(r>=pathEval.length || c>=pathEval[0].length )
        {
            return 0;
        }
        if(pathEval[r][c]!=-1)
            return pathEval[r][c];
        if((r==pathEval.length-1 && c==pathEval[0].length-1))
        {
            pathEval[r][c]=1;
            return 1;
        }
        pathEval[r][c]=((evalPath(r+1,c,pathEval))  +
                        (evalPath(r,c+1,pathEval)) )  ;

        return pathEval[r][c];

    }
}
