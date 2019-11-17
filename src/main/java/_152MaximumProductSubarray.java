import static java.lang.Math.*;

public class _152MaximumProductSubarray {
    public static void main(String[] args){
        _152MaximumProductSubarray test = new _152MaximumProductSubarray();
        int[] input = new int[]{-2};
        System.out.println(test.maxProduct(input));
    }
    public int maxProduct(int[] nums) {
        if(nums.length >= 1){
            int max = nums[0];
            int continueMax = nums[0];
            int continueMin = nums[0];
            for(int i = 1; i < nums.length; i++){
                continueMin *= nums[i];
                continueMax *= nums[i];

                if(nums[i] < 0){
                    int temp = continueMax;
                    continueMax = continueMin;
                    continueMin = temp;
                }

                continueMax = max(continueMax, nums[i]);
                continueMin = min(continueMin, nums[i]);

                if(continueMax > max){
                    max = continueMax;
                }
            }
            return max;
        }
        return 0;
    }
}
