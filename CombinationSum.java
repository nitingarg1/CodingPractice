import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
    System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7},7));
    }

    public Set<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> resultList = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum( candidates, target, 0, resultList, new ArrayList<Integer>());
        return resultList;
    }

    public void  combinationSum(int[] candidates, int target, int index, Set<List<Integer>> resultList, List<Integer>interimList) {
        if(index>=candidates.length || target<0){
            return ;
        }
        if(target==0){
            resultList.add(new ArrayList<>(interimList));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            interimList.add(interimList.size(),candidates[i]);
            combinationSum(candidates,target-candidates[i],i,resultList,interimList);
            interimList.remove(interimList.size()-1);
        }
    }
}
