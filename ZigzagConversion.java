import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING",1));
    }

    public String convert(String s, int numRows) {
    Map<Integer,StringBuilder> sbMap = new HashMap<>();
    int pos=0;
    int diff=1;
    for (int i =0;i<s.length();i++){
        //get the position SB
        StringBuilder sb = sbMap.getOrDefault(pos,new StringBuilder());
        sb.append(s.charAt(i));
        sbMap.put(pos,sb);
        //check if its first row
        if(pos==0)
            pos=pos+1;
        if(pos==numRows-1)
            pos=pos+1;
    }
    StringBuilder res = new StringBuilder();
    for(int i=0;i<numRows;i++){
        if(sbMap.get(i)!=null)
        res.append(sbMap.get(i));
    }
    return res.toString();
    }
}
