public class _56MergeIntervals {
    public static void main(String[] args){
        _56MergeIntervals test = new _56MergeIntervals();
        int[][] a = new int[4][2];
        a[0][0] = 15;
        a[0][1]= 18;
        a[1][0] = 8;
        a[1][1]= 10;
        a[2][0] = 2;
        a[2][1] = 6;
        a[3][0] = 1;
        a[3][1] = 3;
        int[][] result = test.merge(a);
        System.out.println(result);
    }
    public int[][] merge(int[][] intervals) {
        //1. Sorting by the first element
        for(int i = 0; i < intervals.length; i ++){
            for(int j = i; j >= 0;j --){
                if(j != 0 && intervals[j][0] < intervals[j - 1][0]){
                    int a = intervals[j - 1][0];
                    int b = intervals[j - 1][1];
                    intervals[j - 1][0] = intervals[j][0];
                    intervals[j - 1][1] = intervals[j][1];
                    intervals[j][0] = a;
                    intervals[j][1] = b;
                }
            }
        }

        //2.merge
        int[][] merge = new int[intervals.length][2];
        int pointer = -1;
        for(int i = 0; i < intervals.length; i++){
            if(i > 0){
                if(intervals[i][0] <= merge[pointer][1] && intervals[i][1] > merge[pointer][1]){
                    merge[pointer][1] = intervals[i][1];
                }else if(intervals[i][0] > merge[pointer][1]){
                    merge[++pointer][0] = intervals[i][0];
                    merge[pointer][1] = intervals[i][1];
                }
            }else{
                merge[i][0] = intervals[i][0];
                merge[i][1] = intervals[i][1];
                pointer++;
            }
        }

        //3. cut off extra elements
        int[][] result = new int[pointer + 1][2];
        for(int i = 0; i <= pointer; i++){
            result[i][0] = merge[i][0];
            result[i][1] = merge[i][1];
        }
        return result;
    }
}
