public class _136SingleNumber {
    public static void main(String[] args){
        _136SingleNumber test = new _136SingleNumber();
        int[] input = new int[]{5,7,33,5,7,1,2,2,1};
        System.out.println(test.singleNumber(input));
    }
    public int singleNumber(int[] nums) {
        int sum = 0;
        //使用异或 exclusive or把数组内所有元素加起来，重复的元素异或和为0，最后剩下的就是不重复的
        for(int i = 0; i < nums.length; i++){
            sum ^= nums[i];
        }
        return sum;
    }
}
