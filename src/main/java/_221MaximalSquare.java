public class _221MaximalSquare {
    public static void main(String[] args){
        _221MaximalSquare test = new _221MaximalSquare();
        char[][] matrix = new char[][]{new char[]{'1','0','1','0','0'},
                new char[]{'1','0','1','1','1'},
                new char[]{'1','1','1','1','1'},
                new char[]{'1','0','0','1','0'}};
        System.out.println(test.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length < 1){
            return 0;
        }
        int[][] size = new int[matrix.length][matrix[0].length];
        int maxSize = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1'){

                    if(i == 0 || j == 0){
                        size[i][j] = 1;
                        if(maxSize < 1)
                            maxSize = 1;
                    }else{
                        int upleft = size[i-1][j-1];
                        int up = size[i-1][j];
                        int left = size[i][j-1];
                        int newSize = 1 + minimum(upleft, up, left);
                        size[i][j] = newSize;
                        if(newSize > maxSize){
                            maxSize = newSize;
                        }
                    }
                }
            }
        }
        return (maxSize*maxSize);
    }

    private int minimum(int upleft, int up, int left) {
        if(upleft <= up && upleft <= left){
            return upleft;
        }else if(up <= upleft && up <= left){
            return up;
        }else{
            return left;
        }
    }
}
