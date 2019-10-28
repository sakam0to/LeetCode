public class _724FindPivotIndex {
    public static void main(String[] args){
        _724FindPivotIndex test = new _724FindPivotIndex();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(test.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int left = 0;//the sum of number in the left of the pivot
        int right = sum;//the sum of number in the right of the pivot
        for(int i = 0; i < nums.length; i++){
            right -= nums[i];
            //if nums[i] is the pivot
            if(left == right){
                return i;
            }else{
                left += nums[i];
            }
        }
        return -1;
    }
}
