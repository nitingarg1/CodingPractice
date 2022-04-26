import java.util.Stack;


public class DailyTemperature {
    public static void main(String[] args) {
        new DailyTemperature().dailyTemperatures(new int []{89,62,70,58,47,47,46,76,100,70});
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int [] res = new int[temperatures.length];
        int preIndex=temperatures.length-1;
        for(int i=temperatures.length-1;i>=0;i--){
            while(st.size()>0 && temperatures[i]>=st.peek()[1]){
                st.pop();
            }
            res[i]=st.size()>0?st.peek()[0]-i:0;
            int[] temp = {i,temperatures[i]};
            st.add(temp);
        }
    return res;
    }
}
