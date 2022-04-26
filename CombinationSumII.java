import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public Set<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> resultList = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, resultList, 0, new ArrayList<>());
        return resultList;
    }

    public void  combinationSum2(int[] candidates, int target, Set<List<Integer>> resultList, int index, List<Integer> interim) {
        if(index>candidates.length || target<0 ){
            return ;
        }
        if(target==0){
            resultList.add(new ArrayList<>(interim));
        }
        for( int i = index; i<candidates.length; i++){
            interim.add(interim.size(),candidates[i]);
            combinationSum2(candidates, target-candidates[i], resultList, i+1,interim);
            interim.remove(interim.size()-1);
        }
    }
}
