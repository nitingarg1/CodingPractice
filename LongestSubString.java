import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
//        System.out.println("abcabcbb" + new LongestSubString().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("abcabcbb" + new LongestSubString().lengthOfLongestSubstring("bbbbbb"));
//        System.out.println("abcabcbb" + new LongestSubString().lengthOfLongestSubstring("pwwkew"));
        System.out.println("abcabcbb" + new LongestSubString().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring (String s){
        if(s==null || s.length()==0)
            return 0;
        int start=0;
        int maxLength=0;
        Map<Character,Integer> characterMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(characterMap.get(c)!=null){
                start=Math.max(characterMap.get(c)+1,start);
            }
            characterMap.put(c,i);
            maxLength=Math.max(maxLength,i-start);
        }
        return maxLength +1;
    }
}
