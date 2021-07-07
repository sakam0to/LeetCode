import java.util.*;
public class _1338ReduceArraySizetoTheHalf {
    public static void main(String[] args){
        _1338ReduceArraySizetoTheHalf solution = new _1338ReduceArraySizetoTheHalf();
        solution.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] value = new int[list.size()];
        int index = value.length - 1;
        for(Map.Entry<Integer, Integer> each : list){
            value[index--] = each.getValue();
        }

        int count = 0;
        int size = 0;
        for(int i = 0; i < value.length; i++){
            if(count >= arr.length/2)
                break;
            count += value[i];
            size++;
        }
        return size;
    }
}
