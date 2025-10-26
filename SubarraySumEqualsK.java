import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    //Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    //A subarray is a contiguous non-empty sequence of elements within an array.

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int poll = prefixSum - k;
            res += map.getOrDefault(poll, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args){
        int []nums = {1,2,3};
        int target = 3;
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int output = obj.subarraySum(nums, target);
        System.out.println(output);
    }
}
