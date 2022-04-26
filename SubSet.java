import javax.naming.ldap.SortControl;
import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        System.out.println(new SubSet().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        getAllSubsets(nums,0,out,new ArrayList<Integer>());
        return out;
    }

    public void getAllSubsets(int[] nums,int index,List<List<Integer>> out, List<Integer> interim ){
        if(index>=nums.length) {
            return;
        }
        for(int i=index;i<nums.length;i++){
            interim.add(nums[i]);
            getAllSubsets(nums,i+1,out,interim);
            out.add(new ArrayList<Integer>(interim));
            interim.remove(interim.size()-1);
        }
    }
}
