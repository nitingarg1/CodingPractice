import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationSequence {
    public static void main(String[] args) {
        //System.out.println(new PermutationSequence().getPermutation(3,3));
        System.out.println(new PermutationSequence().getPermutation(4,9));
//        System.out.println(new PermutationSequence().getPermutation(3,1));
    }

    public String getPermutation(int n, int k) {
        k=k-1;
        List<Integer> num = new ArrayList<>();
        //create the number list
        for(int i=0;i<n;i++)
            num.add(i+1);
        StringBuilder sb = new StringBuilder();
        int fact = fact(--n);

        while(true){
        int numIndex = k/fact;
        sb.append(num.get(numIndex));
        num.remove(numIndex);
        if(num.size()==0)
            break;
        k=k%fact;
        fact=fact/n--;

        }
        return sb.toString();
    }

    private int fact(int k){
        if(k<=1)
            return 1;
        return k*fact(k-1);
    }

}
