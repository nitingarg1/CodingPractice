import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] str){
        //create a Map of all the unique char sequence
        Map<String,Integer> map = new HashMap<>();
        int count=0;
        List<List<String>> outPut = new ArrayList<>();
        for(String singleString : str){
            char[] charArray= singleString.toCharArray();
            Arrays.sort(charArray);
            if(map.get(Arrays.toString(charArray))==null) {
                map.put(Arrays.toString(charArray), count);
                outPut.add(new ArrayList<>());
                count++;
            }
        }

        for(String singleString : str){
            char[] charArray= singleString.toCharArray();
            Arrays.sort(charArray);
            int index=map.get(Arrays.toString(charArray));
            if(outPut.get(index)==null){
                outPut.add(count,new ArrayList<String>());
            }
            outPut.get(index).add(singleString);
        }
        return outPut;
    }
}
