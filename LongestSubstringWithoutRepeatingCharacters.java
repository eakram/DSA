import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest substring without duplicate characters.
    
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            if(map.getOrDefault(s.charAt(right), -1) >= left){
                left = map.getOrDefault(s.charAt(right), -1) + 1;
            }
            max = Math.max(max, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return max;
    }
    public static void main(String[] args){
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        int output = obj.lengthOfLongestSubstring(s);
        System.out.println(output);
    }
}
