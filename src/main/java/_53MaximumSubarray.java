/**
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * int result[] = new int[nums.length]
 * -2 -> result[0]
 * 1 backward see result[0] < 0? 1 -> result[1]
 * -3 backward see result[1] > 0? -3 + 1 -> result[2]
 *
 * nums[i] backward see if result[i-1] > 0 -> nums[i]+result[i-1] -> result[i]
 * else nums[i] -> result[i]
 *
 * find max(nums[]) also be able to find elements of sub array
 */
public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result[] = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];

        for(int i = 1; i < nums.length; i++){
            if(result[i - 1] > 0){
                result[i] = nums[i] + result[i - 1];
            }else{
                result[i] = nums[i];
            }

            if(result[i] > max){
                max = result[i];
            }
        }
        return max;
    }
}
