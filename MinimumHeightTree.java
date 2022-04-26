import jdk.internal.org.objectweb.asm.Handle;

import java.util.*;
import java.util.stream.IntStream;

public class MinimumHeightTree {
    public static void main(String[] args) {
        System.out.println(new MinimumHeightTree().findMinHeightTrees(6, new int [][]{{0,1},{0,2},{0,3},{3,4},{4,5}}));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    int graphDegree[]= new int[n];
    Map<Integer,List<Integer>> graph = new HashMap<>();
    IntStream.range(0,n).forEach(i->graph.put(i,new ArrayList<>()));
    // calculate the degree of each vertex
    for(int[] edge: edges){
        graphDegree[edge[0]]+=1;
        graphDegree[edge[1]]+=1;
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
    }
        Queue<Integer> leafNodes = new LinkedList<>();
    //add all the leaf node
        for(int i=0;i<n;i++){
            if (graphDegree[i]==1)
                leafNodes.add(i);
        }
        while(graph.size()>2) {
            int size=leafNodes.size();
            for (int in = 0; in < size; in++) {
                Integer i = leafNodes.poll();
                for (int v : graph.get(i)) {
                    graphDegree[v] -= 1;
                    if (graphDegree[v] == 1)
                        leafNodes.add(v);
                }
                graph.remove(i);
            }
        }
        return new ArrayList<Integer>(graph.keySet());
    }
}
