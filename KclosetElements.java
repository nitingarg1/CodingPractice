import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KclosetElements {
    public static void main(String[] args) {
        System.out.println(new KclosetElements().kClosestNumbers(new int[]{1,4,6,10,20},21,4));
    }

    public int[] kClosestNumbers(int[] A, int target, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[] i0,int[] i1){
                return i0[0]==i1[0]?Integer.compare(i1[1],i0[1]):Integer.compare(i1[0],i0[0]);
            }
        });
        for(int i: A){
            if(pq.size()<k){
                pq.offer(new int[]{Math.abs(target-i),i});
            }else if(pq.peek()[0]>Math.abs(target-i)){
                pq.offer(new int[]{Math.abs(target-i),i});
                pq.poll();
            }
        }
        int [] result = new int[k];
        for (int i=k-1;i>=0;i--){
            result[i]=pq.poll()[1];
        }
        return result;


    }
}
