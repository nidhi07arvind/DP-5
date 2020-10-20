/*
TC: for loop - O(n^2), substring inbuilt function - O(n). So, it is O(n^3)
SC: dp array: O(n) n - length of s, hashset: O(n) - length of dict

1. words in dictionary are added to set.
2. check if substrings from start-end pointer are present in set && the substring before current substring is also present.
3. DP array is created.
4. If we are able to generate string s from dict, the result of last cell in dp array would be true.

*/
import java.util.*;

public class WordBreak{
    public boolean wordbreak(String s, List<String> dict){
        //null condition
        if(s == null || s.length() == 0) return true;
        HashSet<String> set = new HashSet<>(dict);

        boolean[] dp = new boolean[s.length() + 1];
        //base case
        dp[0] = true;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j , i))){
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args){
        List<String> dict = Arrays.asList("leet", "code");
        String s = null;
        WordBreak wb = new WordBreak();

        System.out.println(wb.wordbreak(s, dict));
    }
}