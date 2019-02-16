import java.util.Arrays;
/**
 * @author zhujingjie
 * @project LeetCode
 * @description 4
 * @date 2019-02-15 11:36
 */
public class _4MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 第0步：排序
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        /**
         * 第一步：判断中位数位置medEven或medOdd
         */
        boolean isEven = ((nums1.length + nums2.length) % 2 == 0);
        int medOdd = (nums1.length + nums2.length) / 2;
        int[] medEven = {medOdd - 1, medOdd};

        /**
         * 第二步：遍历两个数组，找到中位数
         */
        double median = 0;
        int i = 0, j = 0, index = 0;
        while(i < nums1.length && j < nums2.length){
            if(isEven && index >= medEven[0]){
                /**
                 * 总数为偶，且当前位置已到达中位数位置
                 */
                if(index == medEven[0]){
                    median = (nums1[i] < nums2[j])? nums1[i++] : nums2[j++];
                } else{
                    median = (median + ((nums1[i] < nums2[j])? nums1[i++] : nums2[j++])) / 2;
                    return median;
                }
            } else if(!isEven && index == medOdd){
                /**
                 * 总数为寄，且当前位置已到达中位数位置
                 */
                median = (nums1[i] < nums2[j])? nums1[i++] : nums2[j++];
                return median;
            } else{
                /**
                 * 未到达中位数位置，继续遍历
                 */
                if(nums1[i] < nums2[j]){ i++;}
                else{j++;}
            }
            index++;
        }

        /**
         * 继续遍历剩余数组
         */
        while(i < nums1.length){
            if(isEven && index >= medEven[0]){
                /**
                 * 总数为偶，且当前位置已到达中位数位置
                 */
                if(index == medEven[0]){
                    median = nums1[i++];
                } else{
                    median = (median + nums1[i++]) / 2;
                    return median;
                }
            } else if(!isEven && index == medOdd){
                /**
                 * 总数为寄，且当前位置已到达中位数位置
                 */
                median = nums1[i++];
                return median;
            } else{
                /**
                 * 未到达中位数位置，继续遍历
                 */
                i++;
            }
            index++;
        }
        while(j < nums2.length){
            if(isEven && index >= medEven[0]){
                /**
                 * 总数为偶，且当前位置已到达中位数位置
                 */
                if(index == medEven[0]){
                    median = nums2[j++];
                } else{
                    median = (median + nums2[j++]) / 2;
                    return median;
                }
            } else if(!isEven && index == medOdd){
                /**
                 * 总数为寄，且当前位置已到达中位数位置
                 */
                median = nums2[j++];
                return median;
            } else{
                /**
                 * 未到达中位数位置，继续遍历
                 */
                j++;
            }
            index++;
        }
        return median;
    }

    public static void main(String[] args){
        _4MedianofTwoSortedArrays test = new _4MedianofTwoSortedArrays();
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
