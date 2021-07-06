import java.util.*;

public class _658FindKClosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            LinkedList<Integer> result = new LinkedList<>();

            int i = findNearestIndex(arr, x);
            result.add(arr[i]);

            int lPointer = i - 1;
            int rPointer = i + 1;

            while(lPointer >= 0 && rPointer < arr.length){
                if(result.size() >= k)
                    break;

                if(Math.abs(arr[lPointer] - x) <= Math.abs(arr[rPointer] - x)){
                    result.addFirst(arr[lPointer]);
                    lPointer--;
                }
                else {
                    result.addLast(arr[rPointer]);
                    rPointer++;
                }
            }

            while(lPointer >= 0){
                if(result.size() >= k)
                    break;

                result.addFirst(arr[lPointer]);
                lPointer--;
            }

            while(rPointer < arr.length){
                if(result.size() >= k)
                    break;

                result.addLast(arr[rPointer]);
                rPointer++;
            }

            return result;
        }

        private int findNearestIndex(int[] arr, int x){
            int left = 0;
            int right = arr.length - 1;

            //Return if find
            while(left <= right){
                int mid = (left + right) / 2;

                if(arr[mid] == x)
                    return mid;

                if(arr[mid] > x)
                    right = mid - 1;

                if(arr[mid] < x)
                    left = mid + 1;
            }

            //Not Found Here

            //Overflow
            if(left >= arr.length)
                return right;
            if(right < 0)
                return left;

            //Not Overflow Here

            if(Math.abs(arr[right] - x) <= Math.abs(arr[left] - x))
                return right;
            else
                return left;
        }
    }
}
