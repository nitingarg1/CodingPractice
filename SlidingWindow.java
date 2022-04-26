import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow s = new SlidingWindow();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(s.minWindow("a","aa"));
        System.out.println(s.minWindow("a","a"));
    }
    public String minWindow(String s, String t) {
        int start=0;
        int end=0;
        int charCount=t.length();
        int minLength = Integer.MAX_VALUE;
        String minLengthString="";
        Map<Character,Integer> charMap = charMap(t);
        for(int i=0;i<s.length();i++){
            if(charMap.get(s.charAt(i))!=null){
                int count = charMap.get(s.charAt(i));
                count--;
                charMap.put(s.charAt(i),count);
                if(count==0){
                    charCount--;
                }
            }

            if(charCount==0){
                end=i;
                if(minLength>end-start+1){
                   minLength=end-start+1;
                   minLengthString=s.substring(start,end+1);
                }
               start= startPosition(s,start,i,charMap);
                charCount++;
            }
        }
        minLengthString=minLengthString.length()<end-(start-1)+1?minLengthString:s.substring(start-1,end+1);
        return minLengthString;

    }

    public Map<Character,Integer> charMap(String s){
        Map<Character,Integer> charMap= new HashMap<>();
        for(Character c: s.toCharArray()){
            if(charMap.get(c)==null)
                charMap.put(c,0);
            charMap.put(c,charMap.get(c)+1);
        }
        return charMap;
    }

    public int startPosition(String s,int start, int end,Map<Character,Integer> map){
        while(start<end){
            char c = s.charAt(start);
            start++;
            if(map.get(c)!=null){
                map.put(c,map.get(c)+1);
                if(map.get(c)>0)
                break;
            }

        }
        return start;
    }
}
