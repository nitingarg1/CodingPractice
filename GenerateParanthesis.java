import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println((new GenerateParanthesis()).generateParenthesis(10));

    }

    public List<String> generateParenthesis(int n) {
    return generateParenthesis(0,0,new ArrayList<>(),n,"");
    }

    public List<String> generateParenthesis(int open, int close, List<String> result, int totalParam,String s) {
        if(open==close && open >=totalParam){
            result.add(s);
        }
        if(open <totalParam){
            generateParenthesis(open+1,close,result,totalParam,s+"(");
        }
        if(close <open){
            generateParenthesis(open,close+1,result,totalParam,s+")");
        }
        return result;
    }
}
