public class _70ClimbingStairs {
    /**爬楼梯的公式，n骱台阶= 2级/步 * x步 + 1级/步 * y步
     * x可以从0到 n/2（向下取整）
     * y对应= n - 2x
     * 可以任选在n骱中任选y个位置走一步，其余位置走两步，所以对于y的每个不同取值，可能的位置有C（y，n）个
     * 最后的总和即 sigma（x：0-> n/2）C(n-2x, n);
     */
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for(int i = 2; i < n; i++){
            stairs[i] = stairs[i - 1] + stairs[i - 2];//Fibonacci
        }
        return stairs[n - 1];
    }
}
