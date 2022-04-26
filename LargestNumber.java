import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
    System.out.println(new LargestNumber().largestNumber(new int[]{0,0}));
    }

    public String largestNumber(int[] nums) {
        String [] strNum = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strNum[i]=String.valueOf(nums[i]);

        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String maxNumber="";
        if(!strNum[0].equals("0") ){
            for (String s : strNum)
                maxNumber = maxNumber + s;
        }
        else
                maxNumber=maxNumber+0;
        return maxNumber;
    }
}
