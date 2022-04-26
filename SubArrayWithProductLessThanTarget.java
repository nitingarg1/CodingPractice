import java.util.ArrayList;
import java.util.List;

public class SubArrayWithProductLessThanTarget {
    public static void main(String[] args) {
        System.out.println(new SubArrayWithProductLessThanTarget().getAllSubArray(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(new SubArrayWithProductLessThanTarget().getAllSubArray(new int[] { 8, 2, 6, 5 }, 50));
    }

    public List<List<Integer>> getAllSubArray( int [] arr,int target){
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<target) {
                ArrayList<Integer> interim = new ArrayList<>();
                interim.add(arr[i]);
                output.add(new ArrayList<>(interim));
                getAllSubArray(target, arr, i+1, arr[i], output, interim);
            }
        }
        return output;
    }

    public void getAllSubArray(int target, int [] arr,int index, int multiplier,List<List<Integer>> output, List<Integer> interim ){
        if(index>=arr.length)
            return;
        for(int i=index;i<arr.length;i++){
            multiplier=multiplier*arr[i];
            if(multiplier<target) {
                interim.add(arr[i]);
                output.add(new ArrayList<>(interim));
                getAllSubArray(target, arr, i + 1, multiplier*arr[i], output, interim);
            }else
                return;
        }
    }
}
