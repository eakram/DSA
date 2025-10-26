import java.util.HashMap;
import java.util.Map;


class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //You can return the answer in any order.

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[]{i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args){
        int []nums = {2,7,11,15};
        int target = 9;
        TwoSum obj = new TwoSum();
        int[] output = obj.twoSum(nums, target);
        System.out.print("[");
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + ", ");
        }
        System.out.println("]");
    }
}