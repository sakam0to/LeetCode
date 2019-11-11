import java.util.HashMap;

/**
 * Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
 *
 * If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
 * Example 1:
 *
 * Input: nums = [2,2,1,1,5,3,3,5]
 * Output: 7
 * Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * Output: 13
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,2,2,2]
 * Output: 5
 *
 * Example 4:
 *
 * Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
 * Output: 8
 */
public class _5225MaximumEqualFrequency {
    public static void main(String[] args){
        _5225MaximumEqualFrequency test = new _5225MaximumEqualFrequency();

        int[] nums = new int[]{1,1,1,2,2,2};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{1,2};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{2,2,1,1,5,3,3,5};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{1,1,1,2,2,2};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{10,2,8,9,3,8,1,5,2,3,7,6};
        System.out.println(test.maxEqualFreq(nums));
        nums = new int[]{10};
        System.out.println(test.maxEqualFreq(nums));
    }

    public int maxEqualFreq(int[] nums) {
        int[] howManyElementNeedRemoveAtEachPosition = new int[nums.length];
        HashMap<Integer, Integer> numberAndCount = new HashMap<Integer, Integer>();
        int mostCount = 0;
        int countOfMostCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(!numberAndCount.containsKey(nums[i])){
                numberAndCount.put(nums[i],1);
            }else{
                Integer count = numberAndCount.get(nums[i]);
                count++;
                numberAndCount.put(nums[i],count);
            }
            int count = numberAndCount.get(nums[i]);
            if(count != mostCount){
                int countOfCurrentCount = 0;
                for(Integer e : numberAndCount.keySet()){
                    if(numberAndCount.get(e).equals(mostCount)){
                        countOfMostCount++;
                    }else if(numberAndCount.get(e).equals(count)){
                        countOfCurrentCount++;
                    }
                }
                if(countOfCurrentCount > countOfMostCount){
                    mostCount = count;
                }
                if(countOfCurrentCount == countOfMostCount && count < mostCount){//x=
                    mostCount = count;
                }
            }

            int howManyElementNeedRemove = 0;

            for(Integer e : numberAndCount.keySet()){
                if(numberAndCount.get(e) < mostCount){
                    howManyElementNeedRemove += numberAndCount.get(e);
                }else if(numberAndCount.get(e) > mostCount){
                    howManyElementNeedRemove += (numberAndCount.get(e) - mostCount);
                }
            }
            howManyElementNeedRemoveAtEachPosition[i] = howManyElementNeedRemove;
        }

        for(int i = howManyElementNeedRemoveAtEachPosition.length - 1; i >= 0; i--){
            if(howManyElementNeedRemoveAtEachPosition[i] == 1){
                return i + 1;
            }
        }
        return nums.length;
    }
}
