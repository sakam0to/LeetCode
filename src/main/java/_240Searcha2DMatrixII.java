public class _240Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        //从左上角下楼梯：先向左，直到遇到比target小的，再向下，直到遇到比target大的，循环往复直到出界
        int m = 0;
        int n = matrix[m].length - 1;
        boolean left = true;
        while(m < matrix.length && n >= 0){
            if(matrix[m][n] == target){
                return true;
            }

            if(left){//toward left
                if(matrix[m][n] > target){
                    n--;
                    continue;
                }else{
                    m++;
                    left=false;
                    continue;
                }
            }else{//downward
                if(matrix[m][n] < target){
                    m++;
                    continue;
                }else{
                    n--;
                    left=true;
                    continue;
                }
            }
        }
        return false;
    }
}
