import java.util.*;
import java.util.stream.IntStream;

public class NumOfProvinces {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
    Map<Integer, List<Integer>> connectionMap = new HashMap<>();
    int provience =0;
    int [] visited = new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            for (int j=0;j<isConnected[i].length;j++){
                if(connectionMap.get(i)==null)
                    connectionMap.put(i,new ArrayList<Integer>());
                if(j!=i && isConnected[i][j]==1)
                    connectionMap.get(i).add(j);
            }
        }

        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                provience++;
                Queue<Integer> visitedQueue = new LinkedList<>();
                visitedQueue.add(i);
                while(visitedQueue.size()!=0){
                    int region = visitedQueue.poll();
                    visited[region]=1;
                    if(connectionMap.get(region)!=null)
                        for(int j :connectionMap.get(region)){
                            if(visited[j]==0)
                                visitedQueue.add(j);
                        }
                }
            }
        }
        return provience;
    }

    public int findCircleNum2(int[][] isConnected) {
        int [] visited = new int[isConnected.length];
        int prov =0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                prov++;
            }
        }
        return prov;
    }

//    public boolean checkProvi(int[][] isConnected,)
}
