import java.util.*;

public class Closet3Sum {
    public static void main(String[] args) {
    System.out.println(Closet3Sum.threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(null==nums || nums.length<3){
            return -1;
        }
        int result = -1;
        Arrays.sort(nums);
        int maxDiff = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
                if(maxDiff>Math.abs(target-sum)){
                    maxDiff = Math.abs(target-sum) ;
                    result = sum;
                }
            }
        }
        return result;
    }
}
