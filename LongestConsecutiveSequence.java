import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    //You must write an algorithm that runs in O(n) time.

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    set.remove(num);
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int []nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int output = obj.longestConsecutive(nums);
        System.out.println(output);
    }
}
