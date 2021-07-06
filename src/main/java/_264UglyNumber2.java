import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _264UglyNumber2 {
    public static void main(String[] args){
        _264UglyNumber2 solution = new _264UglyNumber2();
        System.out.println(solution.nthUglyNumber(1400));
    }
    public int nthUglyNumber(int n) {
        //和ugly number的思路刚好相反，用累加的方式从底层向上，每一个ugly，它的2，3，5倍依然是丑数,
        long[] uglyArray = new long[n];
        int i = 0;
        uglyArray[i] = 1;
        //用小根堆，存储所有的候选值
        Queue<Long> candidates = new PriorityQueue<>();
        while(i < n - 1){
            //超过所需要的数字就不再计算候选值了
            if(candidates.size() <= n + 5){ //至多需要5个额外空间排序
                if(!candidates.contains(uglyArray[i] * 2)){
                    candidates.add(uglyArray[i] * 2);
                }
                if(!candidates.contains(uglyArray[i] * 3)){
                    candidates.add(uglyArray[i] * 3);
                }
                if(!candidates.contains(uglyArray[i] * 5)){
                    candidates.add(uglyArray[i] * 5);
                }
            }
            uglyArray[++i] = candidates.poll();
        }
        return (int)uglyArray[n - 1];
    }
}
