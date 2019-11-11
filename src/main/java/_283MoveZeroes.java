public class _283MoveZeroes {
    public static void main(String[] args){
        _283MoveZeroes test = new _283MoveZeroes();
        test.moveZeroes(new int[]{0,1,0,3,12});
    }
    public void moveZeroes(int[] nums) {
        int firstZeroPointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){//若当前位置i的数字为0，则firstZeroPointer会停留在原地。
                if(firstZeroPointer < i){ //firstZeroPointer == i 说明当前位置i之前没有可用的0元素， 反之则说明在当前位置i之前有零元素可以替换
                    nums[firstZeroPointer++] = nums[i];
                    nums[i] = 0;
                    while(firstZeroPointer <= i){//在当前位置i之前，找到下一个0元素
                        if(nums[firstZeroPointer] == 0){
                            break;
                        }
                        firstZeroPointer++;
                    }
                }else{
                    firstZeroPointer++;
                }
            }
        }
    }
}
