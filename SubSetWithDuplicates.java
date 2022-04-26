import java.util.ArrayList;
import java.util.List;

public class SubSetWithDuplicates {

    public static void main(String[] args) {
        List<List<Integer>> result = SubSetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubSetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here
        List<Integer> interim = new ArrayList<>();
        subsets.add(new ArrayList<>());
         findSubsets(nums,0,interim,subsets);

        return subsets;
    }

    public static void  findSubsets(int[] nums, int index, List<Integer> interim, List<List<Integer>> subsets){
        if(index>=nums.length)
            return;
        for(int i=index;i<nums.length;i++){
            if(i==index || nums[i]!=nums[i-1]) {
                interim.add(nums[i]);
                findSubsets(nums, i + 1, interim, subsets);
                subsets.add(new ArrayList<Integer>(interim));
                interim.remove(interim.size() - 1);
            }
//            }else{
//                findSubsets(nums, index + 1, interim, subsets);
//            }
        }
    }
}
