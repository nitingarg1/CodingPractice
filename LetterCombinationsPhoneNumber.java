import java.util.*;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String>  letterCombinations(String digits) {
        if(digits == null || digits.length()<=0){
            return Collections.EMPTY_LIST;
        }
        List<String> lStr = new ArrayList<>();
        lStr.add("");
        for(char c: digits.toCharArray()){
            lStr = getLetterCombination(lStr,c);
        }
    return lStr;
    }

    public static List<String> getLetterCombination(List<String> lStr, char num){
        List<String> result = new ArrayList<>();
        for(String s : lStr){
            for(Character c: getNumberCharMap().get(num)){
                result.add(s+c);
            }
        }
        return result;
    }

    public static Map<Character,Character[]> getNumberCharMap(){
        Map<Character,Character[]> charMap = new HashMap<>();
        charMap.put('2',new Character[]{'a','b','c'});
        charMap.put('3',new Character[]{'d','e','f'});
        charMap.put('4',new Character[]{'g','h','i'});
        charMap.put('5',new Character[]{'j','k','l'});
        charMap.put('6',new Character[]{'m','n','o'});
        charMap.put('7',new Character[]{'p','q','r','s'});
        charMap.put('8',new Character[]{'t','u','v'});
        charMap.put('9',new Character[]{'w','x','y','z'});
        return charMap;
    }

}
