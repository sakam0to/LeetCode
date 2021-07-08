public class _378KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix[0].length - 1];

        while(min < max){
            int mid = min + ((max-min)>>1);
            if(k > findTheOrderOfNum(matrix, mid)){
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int findTheOrderOfNum(int[][] matrix, int k){
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] <= k){
                j++;
            }else {
                count += j;
                i--;
            }
        }
        if(j == matrix[0].length){
            count += (i + 1) * matrix[0].length;
        }
        return count;
    }
}
