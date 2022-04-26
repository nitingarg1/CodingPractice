//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ParkingPathHole {
//    Map<String,List<List<Integer>>> result = new HashMap<>();
//    int[][] dir = {{0,1},{0,-1},{1,1},{1,-1},{1,0},{-1,0},{-1,1},{-1,-1}};
//public Map<String,List<String>> getPathHoleDir(int[][] parkBoard){
//    String[][] cache = new String[parkBoard.length][parkBoard[0].length];
//    for( int i=0;i<parkBoard.length;i++){
//        for (int j=0;j<parkBoard[0].length;j++){
//            getPathHoleDir(parkBoard,cache,i,j,new ArrayList<String>());
//        }
//    }
//    return null;
//}
//private String getPathHoleDir(int[][] parkBoard,String[][] cache,int row, int col, ArrayList<String> dataPoints){
//    if (row > parkBoard.length || row < 0 || col > parkBoard.length || col < 0) {
//        return null;
//    }
//    if(cache[row][col]!=null)
//        return cache[row][col];
//    dataPoints.add(row+","+"col");
//    int newRow=-1;
//    int newCol = -1;
//    int preMin = Integer.MAX_VALUE;
//    for(int[] d :dir ){
//        if(!(row+d[0] > parkBoard.length || row+d[0] < 0 || col+d[1] > parkBoard.length || col+d[1] < 0 ) &&
//                parkBoard[row+d[0]][col+d[0]]<preMin){
//            preMin=parkBoard[row+d[0]][col+d[0]];
//            newCol=col+d[0];
//            newRow=row+d[0];
//        }
//    }
//    if(newCol>-1 && newRow>-1 && cache[row][col]!=null)
//        getPathHoleDir(parkBoard,cache,newRow,newCol,dataPoints);
//    String lot = cache[row][col];
//    result.get()
//}
//}
