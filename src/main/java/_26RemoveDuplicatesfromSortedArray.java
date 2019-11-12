import java.util.Arrays;

public class _26RemoveDuplicatesfromSortedArray {
    public static void main(String[] args){
        _26RemoveDuplicatesfromSortedArray test = new _26RemoveDuplicatesfromSortedArray();
        System.out.println(test.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int previous_number = nums[0];
        int duplication_position = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != previous_number){
                nums[duplication_position++] = nums[i];
                previous_number = nums[i];
            }
        }

        nums = Arrays.copyOfRange(nums, 0, duplication_position);
        return nums.length;
    }
}
