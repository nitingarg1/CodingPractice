public class SubArraySumEqualsK {
    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     */

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualsK().subarraySum(new int[]{1},0));
    }
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int start=0;
        int count=0;
        for (int i=0;i<nums.length;i++){
            sum +=nums[i];
            while(sum >k){
                sum -=nums[start];
                start++;
            }
            if(sum==k)
                count++;
        }
        return count;
    }
}
