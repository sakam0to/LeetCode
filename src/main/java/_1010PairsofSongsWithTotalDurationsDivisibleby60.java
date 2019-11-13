import java.util.*;

public class _1010PairsofSongsWithTotalDurationsDivisibleby60 {
    public static void main(String[] args){
        _1010PairsofSongsWithTotalDurationsDivisibleby60 test = new _1010PairsofSongsWithTotalDurationsDivisibleby60();
        int[] input = new int[]{60, 60, 60, 20, 40};
        System.out.println(test.numPairsDivisibleBy60(input));
    }
    public int numPairsDivisibleBy60(int[] time) {
        List<Integer> times = new ArrayList<>();
        for(int i = 0; i < time.length; i++){
            times.add(time[i]);
        }
        Collections.sort(times, new Comparator<Integer>() {
            //按照除以60的余数大小排列
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%60 < o2%60){
                    return -1;
                }else if(o1%60 > o2%60){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        int result = 0;
        int start = 0;
        int end = times.size()  - 1;
        while(start < end){
            if(times.get(start)%60 == 0){
                //任意两个能被60整除的数，加起来也可以被60整除
                int j = start + 1;
                while(j < times.size() && times.get(j)%60 == 0){
                    result++;
                    j++;
                }
                start++;
                continue;
            }
            if((times.get(start) % 60 + times.get(end)% 60) < 60 && (times.get(start) % 60 + times.get(end)% 60) != 0){
                start++;
                continue;
            }else if((times.get(start) % 60 + times.get(end)% 60) > 60){
                end--;
                continue;
            }else{
                // == 60
                //先让start不动，遍历所有可能的配对后，start+1
                int j = end;
                while(j > start && ((times.get(start) + times.get(j)) % 60  == 0)){
                    result++;
                    j--;
                }
                start++;
            }
        }
        return result;
    }
}
