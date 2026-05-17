import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int maxLengthOfSubstring(String s){
        int left=0;
        int maxLength=0;
        Set<Character> set = new HashSet<>();
        for(int right=0; right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }

    public static void main(String[] args){
        LengthOfLongestSubstring lc3 = new LengthOfLongestSubstring();
        String s = "pcwwkew";
        System.out.println(lc3.maxLengthOfSubstring(s));
    }
    
}
