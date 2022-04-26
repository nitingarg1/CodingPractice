import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
       System.out.println(Arrays.toString(new NextPermutation().nextPermutation(new int []{1,2,3})));
//        System.out.println(Arrays.toString(new NextPermutation().nextPermutation(new int []{1,3,2})));
//        System.out.println(Arrays.toString(new NextPermutation().nextPermutation(new int []{3,2,1})));
//        System.out.println(Arrays.toString(new NextPermutation().nextPermutation(new int []{1,5,1})));
    }
    public int[] nextPermutation(int[] nums) {
        int start = -1;
        //find the position of the switch
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        //find start correct position
        if (start >= 0){
            for (int i = nums.length - 1; i>start; i--) {
                if (nums[i]>nums[start]) {
                    swap(nums,start, i);
                    break;
                }
            }
    }
        reverse(nums,start+1);
        return nums;
    }

    private void swap(int[] arr, int f, int s){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]=temp;
    }

    private int[] reverse(int []arr,int start){
        int i=start,j=arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;j--;
        }
        return arr;
    }
}
