public class _88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexm = m - 1;//nums1 实际有效的最后一位
        int indexn = n - 1;//nums2 实际有效的最后一位
        int pointer = m + n - 1;//最后输出的nums1 应该有m+n个元素，所以从m+n-1开始向前走
        while(indexm >= 0 && indexn >= 0){
            if(nums1[indexm] > nums2[indexn]){
                nums1[pointer--] = nums1[indexm--];
            }else{
                nums1[pointer--] = nums2[indexn--];
            }
        }

        while(indexm >= 0){
            nums1[pointer--] = nums1[indexm--];
        }
        while(indexn >= 0){
            nums1[pointer--] = nums2[indexn--];
        }
    }
}
