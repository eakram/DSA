import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int []freq = new int[26];
            for(char c : strs[i].toCharArray())
                freq[c-'a']++;
            StringBuilder key = new StringBuilder();
            for(char c = 'a'; c <= 'z'; c++){
                key.append(c + freq[c - 'a']);
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> output = obj.groupAnagrams(strs);
        System.out.println(output);
    }
}
