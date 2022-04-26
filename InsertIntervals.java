import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class InsertIntervals {
    public static void main(String[] args) {
   int[][] result= new InsertIntervals().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int []{4,8});
   System.out.println(result);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] outPut = new int[intervals.length+1][intervals.length+1];
        Queue<int[]> interValQueue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] obj1, int[] obj2){
                if(obj1[0]==obj2[0])
                    return 0;
                if(obj1[0]>obj2[0])
                    return 1;
                return -1;
            }
        });

        interValQueue.offer(newInterval);
        for(int[] interval : intervals){
            interValQueue.offer(interval);
        }
        outPut[0]=interValQueue.poll();
        int count=0;
        while(interValQueue.size()>0){
            int[] temp = interValQueue.poll();
            if(outPut[count][1]>=temp[0]){
                outPut[count][1]=outPut[count][1]>temp[1]?outPut[count][1]:temp[1];
            }else{
                count++;
                outPut[count]=temp;
            }
        }
        return Arrays.copyOfRange(outPut,0,count+1);
    }
}
