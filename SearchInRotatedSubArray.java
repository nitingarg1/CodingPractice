public class SearchInRotatedSubArray {
    public static void main(String[] argzs) {
        System.out.println(new SearchInRotatedSubArray().search(new int[]{4,5,6,7,0,1,2},0));
    }
    public int search(int[] nums, int target) {
        if(nums==null)
            return -1;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid]>=nums[start]){
                if(target>=nums[start] && target<=nums[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }else{
                if(target>=nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
    return -1;
    }

}
