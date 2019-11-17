import java.util.Comparator;
import java.util.PriorityQueue;

public class _215KthLargestElementinanArray {
    public static void main(String[] args){
        _215KthLargestElementinanArray test = new _215KthLargestElementinanArray();
        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(test.findKthLargest(input, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i: nums){
            heap.add(i);
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.peek();
    }
}
