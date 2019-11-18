public class _198HouseRobber {
    public static void main(String[] args){
        _198HouseRobber test = new _198HouseRobber();
        int[] input = new int[]{2, 1, 1, 2};
        System.out.println(test.rob(input));
    }
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //total数组第i个元素 ，存储的是当选中nums[i]时，最大的total是多少，
        //对于第i个元素，只有两种可能：和上一个选中的元素间隔一位，或者两位，
        //所以只需要比较nums[i - 2] 和nums[i-3]的大小就可以确定nums[i]的值
        int[] total = new int[nums.length];
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[0] + nums[2];
        int max = Math.max(total[1], total[2]);
        for(int i = 3; i < nums.length; i++){
            total[i] = Math.max(total[i - 2] + nums[i], total[i - 3] + nums[i]);
            if(total[i] > max){
                max = total[i];
            }
        }
        return max;
    }
}
