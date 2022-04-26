import java.util.ArrayList;
import java.util.List;

public class GenerateAnagram {
    public static void main(String[] args) {
        System.out.println(new GenerateAnagram().getNGram("abcdef",3));
    }
    public List<String> getNGram(String s, int k){
        List<String> out = new ArrayList<>();
        if (s==null || k>s.length())
            return out;
        for(int i=0;i<=s.length()-k;i++){
            out.add(s.substring(i,i+k));
        }

        return out;
    }
}
