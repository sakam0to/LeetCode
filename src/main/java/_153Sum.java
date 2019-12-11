import java.util.*;

public class _153Sum {
    public static void main(String[] args){
        _153Sum test = new _153Sum();
        int[] input = new int[]{-1,0,1,2,-1,-4};
        for(List<Integer> list: test.threeSum(input)){
            System.out.println();
            for(Integer i : list){
                System.out.print(i+" ");
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        List<List<Integer>> division = sortAndDivideByZero(nums);
        List<Integer> negatives = division.get(0);
        List<Integer> zeros = division.get(1);
        List<Integer> positives = division.get(2);

        //Case1: 2 negative + 1 positive
        for(int i = 0; i < positives.size(); i++){
            int j = negatives.size() - 1;
            while(j >= 1 && positives.get(i) + negatives.get(j) > 0){
                int k = j - 1;
                while(k >= 0 && positives.get(i) + negatives.get(j) + negatives.get(k) >= 0){
                    if(positives.get(i) + negatives.get(j) + negatives.get(k) == 0){
                        result.add(Arrays.asList(negatives.get(j), negatives.get(k), positives.get(i)));
                        break;
                    }
                    k--;
                }
                j--;
            }
        }
        //Case2: 2 positive + 1 negative
        for(int i = 0; i < negatives.size(); i++){
            int j = 0;
            while(j < positives.size() && negatives.get(i) + positives.get(j) < 0){
                int k = j + 1;
                while(k < positives.size() && negatives.get(i) + positives.get(j) + positives.get(k) <= 0){
                    if(negatives.get(i) + positives.get(j) + positives.get(k) == 0){
                        result.add(Arrays.asList(negatives.get(i), positives.get(k), positives.get(j)));
                        break;
                    }
                    k++;
                }
                j++;
            }
        }
        //Case3: 1 positive + 1 zero + 1 negative
        if(zeros.size() > 0){
            //Case3: 1 positive + 1 zero + 1 negative
            for(int i = 0; i < positives.size(); i++){
                int j = negatives.size() - 1;
                while(j >= 0){
                    if(positives.get(i) + negatives.get(j) == 0){
                        result.add(Arrays.asList(negatives.get(j), 0, positives.get(i)));
                        break;
                    }
                    j--;
                }
            }
            //Case4: 3 zero
            if(zeros.size() > 2){
                result.add(Arrays.asList(0, 0, 0));
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.addAll(result);
        return lists;
    }

    private List<List<Integer>> sortAndDivideByZero(int[] nums) {
        quicksort(nums, 0, nums.length);

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();

        for(int i : nums){
            if(i < 0){
                negatives.add(i);
            }else if(i > 0){
                positives.add(i);
            }else{
                zeros.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(negatives);
        result.add(zeros);
        result.add(positives);
        return result;
    }

    private void quicksort(int[] nums, int start, int end) {
        if(end > start && start < nums.length){

            int pivot = nums[start];
            int indexOfPivot = start;
            int lessThanPivot = 0;
            for(int i = start; i < end; i ++){
                if(nums[i] < nums[indexOfPivot]){
                    lessThanPivot++;
                }
            }
            indexOfPivot = lessThanPivot + start;
            int temp = nums[indexOfPivot];
            nums[indexOfPivot] = pivot;
            nums[start] = temp;

            int index0 = start;
            int index1 = indexOfPivot + 1;
            while(index0 < indexOfPivot && index1 < end){
                while(index0 < indexOfPivot && nums[index0] < pivot){
                    index0++;
                }
                while(index1 < end && nums[index1] >= pivot){
                    index1++;
                }
                if(index0 < indexOfPivot && index1 < end){
                    temp = nums[index0];
                    nums[index0] = nums[index1];
                    nums[index1] = temp;
                    index0++;
                    index1++;
                }
            }
            boolean order = true;
            for(int i = start; i < indexOfPivot - 1; i++){
                if(nums[i] > nums[i + 1]){
                    order = false;
                    break;
                }
            }
            if(!order){
                quicksort(nums, start, indexOfPivot);
            }
            order = true;
            for(int i = indexOfPivot; i < end - 1; i++){
                if(nums[i] > nums[i + 1]){
                    order = false;
                    break;
                }
            }
            if(!order){
                quicksort(nums, indexOfPivot + 1, end);
            }
        }
    }
}
