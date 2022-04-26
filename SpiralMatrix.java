import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> outList = new ArrayList<>();
    int top=0,right=matrix[0].length-1,bottom=matrix.length-1,left=0;

    while(top<bottom || left<right){
        //iterating from left to right
        for(int i=left;i<=right;i++){
            outList.add(matrix[top][i]);
        }
        top++;
        //iterating top to bottom
        for(int i=top;i<=bottom;i++){
            outList.add(matrix[i][right]);
        }
        right--;

        if(top>bottom && left>=right)
            break;
        //iterating right to left
        for(int i=right;i>=left;i--){
            outList.add(matrix[bottom][i]);
        }
        bottom--;
        //iterating bottom to top
        for(int i=bottom;i>=top;i--){
            outList.add(matrix[i][left]);
        }
        left++;
    }
    return outList;
    }


}
