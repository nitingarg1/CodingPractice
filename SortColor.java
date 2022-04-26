public class SortColor {
    public static void main(String[] args) {
        new SortColor().sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
    int start=0;
    int end=nums.length-1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==0){
            swap(nums,start,i);
            start++;
        }
    }

        for(int i=nums.length-1;i>=start;i--){
            if(nums[i]==2){
                swap(nums,end,i);
                end--;
            }
        }
    }

    public void swap(int [] arr, int f, int s){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]=temp;
    }
}
