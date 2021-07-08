public class _34FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchFirst(nums, target),binarySearchLast(nums, target)};
    }

    private int binarySearchFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                if(mid == left)
                    return mid;
                else
                    right = mid;
            }
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                if(mid == right || nums[mid + 1] != nums[mid])
                    return mid;
                else
                    left = mid + 1;
            }
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
