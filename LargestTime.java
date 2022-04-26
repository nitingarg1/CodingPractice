import java.util.Arrays;

public class LargestTime {
    public static void main(String[] args) {
        System.out.println(new LargestTime().largestTimeFromDigits(new int[]{2,4,2,4}));
    }
    int maxMin=-1;
    public String largestTimeFromDigits(int[] arr) {
        largestTimeFromDigits(arr,0);
        return maxMin>-1?""+(maxMin/60)/10+ (maxMin/60)%10+":"+(maxMin%60)/10+(maxMin%60)%10:"";
    }

    public void largestTimeFromDigits(int[] arr,int index ) {
        if(index>=4 && validTime(arr)){
            maxMin=Math.max(maxMin,((arr[0]*10+arr[1])*60+arr[2]*10+arr[3]));
        }
        for (int i=index;i<4;i++){
            swap(arr,index,i);
            largestTimeFromDigits(arr,index+1);
            swap(arr,index,i);
        }
    }

    public void swap(int[] arr, int f, int s){
        int t= arr[f];
        arr[f]=arr[s];
        arr[s]=t;
    }

    public boolean validTime(int []arr){
        if( (arr[0]*10+arr[1])>23 || (arr[2]*10+arr[3])>59)
            return false;
        return true;
    }
}
