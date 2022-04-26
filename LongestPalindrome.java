public class LongestPalindrome {
    public static void main(String args[]){
        System.out.println("test");
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int start =0;
        int end = 0;
        int max =0;
        boolean[][]dpArray = new  boolean [s.length()][s.length()];
        for (int gap=0;gap<s.length();gap++){
            for (int i=0,j=gap;j<s.length();j++,i++){
                int len = j-i+1;
                if(len==1){
                    dpArray[i][j]=true;
                }else if (len==2){
                    if(s.charAt(i) == s.charAt(j)){
                        dpArray[i][j]=true;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dpArray[i+1][j-1]==true){
                        dpArray[i][j]=true;
                    }
                }
                if(len >max && dpArray[i][j]){
                    start = i;
                    end = j+1;
                    max=end-start;
                }
            }
        }
        return s.substring(start,end);
    }
}
