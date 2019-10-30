public class _238ProductofArrayExceptSelf {
    public static void main(String[] args){
        _238ProductofArrayExceptSelf test = new _238ProductofArrayExceptSelf();
        int[] input = new int[]{1,2,3,4};
        int[] output = test.productExceptSelf(input);
        System.out.print("The result is: ");
        for(int i : output){
            System.out.print(" "+i);
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeros = 0;//特殊情况，有0，统计0的个数：若只有1个0，则除了0所在的位置，其他位置的值都是0；0若多于1个(i.e. zeros >=2)，则所有位置都为0
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){//若有0，统计0的个数，先不纳入product的计算
                zeros++;
            }else{
                product *= nums[i];
            }
        }

        int result[] = new int[nums.length];
        if(zeros > 1 || nums.length == 1){//输入中有多于一个0或者输入只有一个元素，都可以直接返回0数组
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            if(zeros > 0){//nums中有0（且只有一个0，因为多于1个0的情况已经在上面处理过）
                if(nums[i] == 0){//对于0元素，因为product计算时没有纳入0，所以不需要除0
                    result[i] = product;
                    return result;
                }
                /**对于非0元素，一概为0，所以不用再处理（因为数组元素默认值即为0）
                else{
                }*/
            }else{
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}
