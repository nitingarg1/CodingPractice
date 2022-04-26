public class FindFirstAndLastIndexInSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindFirstAndLastIndexInSortedArray().searchRange(new int[]{5,7,7,8,8,10},8));
    }
    public int[] searchRange(int[] nums, int target) {
    int l =0;
    int r = nums.length-1;
    while(l<=r){
    int mid = l+(r-l)/2;
    if(nums[mid]==target){
        int start=mid;
        int end = mid;
        while(start>=0 && nums[start]==target){
            start--;
        }
        while(end<nums.length && nums[end]==target){
            end++;
        }
        return new int[]{start,end};
    }
    if(nums[mid]>target){
        r=mid-1;
    }else{
        l=mid+1;
    }
    }
    return new int[]{-1,-1};
    }
}
