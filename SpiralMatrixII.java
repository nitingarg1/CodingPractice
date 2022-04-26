public class SpiralMatrixII {

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {

    int [][] spiralArray =new int [n][n];
    int top=0,bottom=n-1,left=0,right=n-1;
    int count=1;
    for(int i=0;i<(n+1)/2;i++){
        for(int ptr=i;ptr<n-i;ptr++){
            spiralArray[i][ptr]=count++;
        }
        for(int ptr=i+1;ptr<n-i;ptr++){
            spiralArray[ptr][n-i-1]=count++;
        }
        for(int ptr=i+1;ptr<n-i;ptr++){
            spiralArray[n-i-1][n-ptr-1]=count++;
        }
        for(int ptr=i+1;ptr<n-i-1;ptr++){
            spiralArray[n-ptr-1][ptr-1]=count++;
        }
    }
    return spiralArray;
    }
}
