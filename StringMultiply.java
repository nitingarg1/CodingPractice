import java.util.Arrays;

public class StringMultiply {
    public static void main(String[] args) {
        System.out.println(new StringMultiply().multiply("123","456"));
    }
    public String multiply(String num1, String num2) {
        if(num1=="0" || num2=="0")
            return "0";
    int [] result = new int[num1.length()+num2.length()];
    int k=1;
    for(int i=num1.length()-1;i>=0;i--){
        multiply(num2, Character.getNumericValue(num1.charAt(i)),  result.length-k++, result);
    }
    StringBuilder sb =new StringBuilder();
    for(int j:result){
        if(sb.length()>0 || j>0){
            sb.append(j);
        }
    }
    return sb.toString();
    }

    public void multiply(String num2, int mul, int endIndex, int [] result){
        int carry =0;
        for(int i=num2.length()-1;i>=0;i--){
            int num=Character.getNumericValue(num2.charAt(i));
            num=num*mul+carry+result[endIndex];
            carry=num/10;
            result[endIndex]=num%10;
            endIndex--;
        }
        result[endIndex]=result[endIndex]+carry;
    }
}
