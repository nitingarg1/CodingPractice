/**
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 */

public class DiagonalTraversal {
    public static void main(String[] args) {
        new DiagonalTraversal().findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public int[] findDiagonalOrder(int[][] mat) {
    int[] result = new int [mat.length*mat[0].length];
    int r = 0;
    int c=0;
    boolean pathFlip= true;
    int count=0;
    while(r<mat.length && c<mat[0].length){
        if(pathFlip) {
            while (r >= 0 && c < mat[0].length) {
                result[count] = mat[r][c];
                r--;
                c++;
                count++;
            }
            pathFlip=!pathFlip;
        }else{
            while (c>=0 && r < mat.length) {
                result[count] = mat[r][c];
                r++;
                c--;
                count++;
            }
            pathFlip=!pathFlip;
        }
        r=r<0?0:r;
        c=c<0?0:c;
    }

    return result;
    }
}
