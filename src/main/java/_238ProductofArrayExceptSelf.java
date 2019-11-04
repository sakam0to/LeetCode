public class _238ProductofArrayExceptSelf {
    public static void main(String[] args){
        _238ProductofArrayExceptSelf test = new _238ProductofArrayExceptSelf();
        int[] input = new int[]{1,0,3,4};
        int[] output = test.productExceptSelf(input);
        System.out.print("The result is: ");
        for(int i : output){
            System.out.print(" "+i);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights  = new int[nums.length];

        int left = 1;
        int right = 1;
        for(int i = 0; i < nums.length; i++){
            lefts[i] = left;
            rights[nums.length - 1 - i] = right;
            left = left * nums[i];
            right =  right * nums[nums.length - 1 - i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = lefts[i] * rights[i];
        }
        return nums;
    }
}
