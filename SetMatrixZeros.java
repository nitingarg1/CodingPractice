public class SetMatrixZeros {

    public static void main(String[] args) {
        new SetMatrixZeros().setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
    public void setZeroes(int[][] matrix) {
    for(int i=0;i<matrix.length;i++){
        boolean rowZero=false;
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                setColZeros(matrix,j,i);
                rowZero=true;
            }
            if(i>0 && matrix[i-1][j]==0)
                matrix[i][j]=0;
        }
        if(rowZero)
            setRowZeros(matrix,i);
    }
    }

    public void setColZeros(int [][] matrix, int col, int row){
        for(int i=row;i>=0;i--){
            matrix[i][col]=0;
        }
    }
    public void setRowZeros(int [][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i]=0;
        }
    }
}
