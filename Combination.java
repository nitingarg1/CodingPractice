import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        System.out.println(new Combination().combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinataion(n,0,new ArrayList<Integer>(),result,k);
        return result;
    }

    public void combinataion(int n, int start, List<Integer> interim, List<List<Integer>> result, int k){
        if(k<1){
            result.add(new ArrayList<Integer>(interim));
            return;
        }

        for(int i=start;i<n;i++){
            interim.add(i+1);
            combinataion(n,i+1,interim,result,k-1);
            interim.remove(interim.size()-1);
        }
    }
}
