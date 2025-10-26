public class SearchInsertPosition {

    //Given a sorted array of distinct integers and a target value, return the index if the target is found. 
    //If not, return the index where it would be if it were inserted in order.
    //You must write an algorithm with O(log n) runtime complexity.

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] > target)
            return 0;
        if(nums[right] < target)
            return right + 1;

        while(right > left){
            int mid = (right + left)/2;
            if(nums[mid] >= target){
                right = mid;
            } 
            else{
                left = mid + 1;
            }
            
        }
        return left;
    }
    public static void main(String[] args){
        int []nums = {1,3,5,6};
        int target = 7;
        SearchInsertPosition obj = new SearchInsertPosition();
        int output = obj.searchInsert(nums, target);
        System.out.println(output);
    }
}
