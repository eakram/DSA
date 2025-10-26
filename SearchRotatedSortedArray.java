public class SearchRotatedSortedArray {


    //There is an integer array nums sorted in ascending order (with distinct values).
    //Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array 
    //is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
    //Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    //You must write an algorithm with O(log n) runtime complexity.

    public int search2(int[] arr, int target) {
        int n = arr.length;
        int pivot = findPivot(arr, target);
        if (target >= arr[pivot] && target <= arr[n - 1]) {
            return binsearch(arr, pivot, n - 1, target);
        } else {
            return binsearch(arr, 0, pivot - 1, target);
        }
    }

    int findPivot(int[] arr, int target) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    int binsearch(int[] arr, int start, int end, int target) {
        int lo = start, hi = end;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo] == target ? lo : -1;
    }

    public int search1(int []arr, int target){
        int n = arr.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > arr[lo]) {
                if (target >= arr[lo] && target <= arr[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= arr[mid + 1] && target <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        return arr[lo] == target ? lo : -1;
    }
    public static void main(String[] args){
        int []nums = {6,7,8,9,1,3,5};
        int target = 8;
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        int output = obj.search2(nums, target);
        System.out.println(output);
    }
}
