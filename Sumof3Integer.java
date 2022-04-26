import java.util.*;

public class Sumof3Integer {
    public static void main(String[] args) {

        System.out.println(Sumof3Integer.threeSum(new int[]{3,0,-2,-1,1,2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(null==nums || nums.length<3){
            return Collections.EMPTY_LIST;
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                }else if(sum > 0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return new ArrayList(result);
    }
}
