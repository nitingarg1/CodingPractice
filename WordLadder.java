import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        System.out.println(test.ladderLength("hot","dog",
                Arrays.asList(new String[]{"hot","dog"})));
    }

    public int ladderLength(String start, String end, List<String> wordList) {
        HashSet<String > dict = new HashSet<>(wordList);
        // write your code here
        if(!dict.contains(end)){
            return 0;
        }
        int count =0;
        Queue<String> words= new LinkedList<>();
        words.add(start);
        while(words.size()!=0){
            count++;
            int size = words.size();
            while(size>0){
                size--;
               if(getAllValidWords(words.poll(),dict,words,end))
                   return count+1;
            }
        }
        return 0;
    }

    public boolean getAllValidWords(String word, Set<String> dict,Queue<String> words, String end){

        for (int i=0;i<word.length();i++){
            StringBuilder sb = new StringBuilder(word);
            for(char x='a';x<='z';x++){
                sb.setCharAt(i,x);
                String test = sb.toString();
                if(dict.remove(test)){
                    if(test.equals(end))
                        return true;
                words.add(sb.toString());
                }
            }
        }
    return false;
    }
}
