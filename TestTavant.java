import java.util.ArrayList;
import java.util.List;

public class TestTavant {

    public static void main(String[] args) {
        System.out.println(new TestTavant().getLonelyNumber(new int[]{1,3,5,3}));
    }
    public List<Integer> getLonelyNumber(int [] arr){
        List<Integer> outPut = new ArrayList<>();

        for(int i=0;i < arr.length;i++){
            //check for left
            boolean left = (i>0) ? (arr[i-1]!=arr[i]+1 && arr[i-1]!=arr[i]-1) : true;
            boolean right=(i<arr.length-1) ? (arr[i+1]!=arr[i]+1 && arr[i+1]!=arr[i]-1) : true;
           if(left&&right)
            outPut.add(arr[i]);
        }
        return outPut;
    }
}
