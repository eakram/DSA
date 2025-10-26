public class BinarySearch {

    //Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
    //If target exists, then return its index. Otherwise, return -1.
    //You must write an algorithm with O(log n) runtime complexity.

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= left){
            int mid = (left + right)/2;
            if(nums[mid] ==  target)
                return mid;
            if(target > nums[mid])
                left = mid + 1;
            else
                right = mid -1;
        }
        return -1;
    }
    public static void main(String[] args){
        int []nums = {1,3,5,6,7,8,9};
        int target = 8;
        BinarySearch obj = new BinarySearch();
        int output = obj.search(nums, target);
        System.out.println(output);
    }
}
