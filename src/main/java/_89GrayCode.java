import java.util.*;

public class _89GrayCode {
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.grayCode(3);
    }

    static class Solution {
        public List<Integer> grayCode(int n) {
            Integer[] a = new Integer[]{0, 1};

            for(int i = 2; i <= n; i++){
                Integer[] b = new Integer[(int) Math.pow(2,i)];

                int one = 1 << (i - 1);

                for(int j = 0; j < b.length; j++){
                    if(j < a.length){
                        b[j] = a[j];
                    } else {
                        b[j] = one | a[a.length - 1 - (j - a.length)];
                    }
                }

                a = b;
            }

            return Arrays.asList(a);
        }
    }
}
