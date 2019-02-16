import java.util.Arrays;

/**
 * @author zhujingjie
 * @project LeetCode
 * @description 1
 * @date 2019-02-14 12:41
 */
public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {

        /**
         * 第0步：准备工作副本
         */
        int[] workload = Arrays.copyOf(nums, nums.length);
        /**
         * 第1步：排序
         */
        Arrays.sort(workload);
        /**
         * 第2步：定义左右游标
         */
        int left = 0;
        int right = workload.length - 1;

        /**
         * 第3步：从左右两个方向遍历数组
         */
        while(right > left){
            int sum = workload[left] + workload[right];
            if(sum > target){
                /**
                 * 右游标左移
                 */
                right--;
            } else if(sum < target){
                /**
                 * 左游标右移
                 */
                left++;
            } else{
                /**
                 * 命中，跳出循环
                 */
                break;
            }
        }

        /**
         * 第4步：一趟遍历找到原数组的下标
         */
        boolean bLeft = false;
        boolean bRight = false;
        for(int i = 0; i < nums.length; i++){
            if(!bLeft && nums[i] == workload[left]){
                left = i;
                bLeft = true;
            }else if(!bRight && nums[i] == workload[right]){
                right = i;
                bRight = true;
            }else if(bLeft && bRight){
                break;
            }
        }
        return new int[]{left, right};
    }
}
