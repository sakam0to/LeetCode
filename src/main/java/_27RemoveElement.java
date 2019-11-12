import java.util.Arrays;

public class _27RemoveElement {
    public static void main(String[] args){
        _27RemoveElement test = new _27RemoveElement();
        System.out.println(test.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int available_position = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[available_position++] = nums[i];
            }
        }

        nums = Arrays.copyOfRange(nums, 0, available_position);
        return nums.length;
    }
}
