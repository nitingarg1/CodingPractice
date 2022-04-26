import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }

    public void permute(int [] nums, int index, List<List<Integer>> result){
        if(index>=nums.length){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i=index; i<nums.length;i++){
            swap(nums,index,i);
            permute(nums,index+1,result);
            swap(nums,index,i);
        }
    }

    public void swap(int[] nums, int f, int s){
        Integer temp= nums[f];
        nums[f]=nums[s];
        nums[s]=temp;
    }
}
