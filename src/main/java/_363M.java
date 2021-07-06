public class _363M {
    public static void main(String[] args){
        _363M solution = new _363M();
        int[][] test = new int[1][2];
        test[0] = new int[]{2,2,-1};
        solution.maxSumSubmatrix(test, 3);
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int best = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int[] c = new int[matrix[0].length];

                //Merge all rows together into one row
                for(int a = i; a <= j; a++){
                    for(int b = 0; b < matrix[0].length; b++){
                        c[b] += matrix[a][b];
                    }
                }

                //Kadane's Algorithm
                for(int p = 0; p < c.length; p++){
                    int cur = 0;

                    for(int q = p; q < c.length; q++){
                        cur += c[q];

                        if(cur > best && cur <= k)
                            best = cur;
                    }
                }
            }
        }
        return best;
    }
}
