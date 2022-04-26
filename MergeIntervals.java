import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(new MergeIntervals().merge(new int[][]{{1,4},{1,5}}));
    }

    public int[][] merge(int[][] intervals) {
    if(intervals==null || intervals.length==1){
        return intervals;
    }
    LinkedList<int[]> merged = new LinkedList<>();
    Arrays.sort(intervals,new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            if(o1[0]>o2[0]){
                return 1;
            }else if (o1[0]==o2[0]){
                return Integer.compare(o1[1],o2[1]);
            }
            return -1;
        }
        });
    int[][] pre = new int[1][2];
    pre[0]=new int[]{-1,-1};
    for(int[] entry : intervals){
        if(pre[0][1]<entry[0]){
            pre[0]=entry;
            merged.add(entry);
        }else if(pre[0][1]<entry[1]){
            pre[0][1]=entry[1];
        }
    }
    return merged.toArray(new int[merged.size()][]);
    }
}
