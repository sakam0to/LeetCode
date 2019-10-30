import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _973KClosestPointstoOrigin {
    public static void main(String[] args){
        _973KClosestPointstoOrigin test = new _973KClosestPointstoOrigin();
        int[][] points = new int[3][2];
        points[0] = new int[]{-5,4};
        points[1] = new int[]{-6,-5};
        points[2] = new int[]{4,6};
        int K=2;
        int[][] result = test.kClosest(points,K);
        for(int[] each: result){
            System.out.print(" ["+each[0]+","+each[1]+"] ");
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> sorting = new ArrayList<int[]>();//存放点坐标和距离
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            int distance = point[0]*point[0] + point[1]*point[1];

            int[] newPoint = new int[]{point[0], point[1], distance};
            sorting.add(newPoint);
        }

        //sorting
        Collections.sort(sorting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] < o2[2]){
                    return -1;
                }else if(o1[2] > o2[2]){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        //取前K个
        int[][] result = new int[K][2];
        for(int i = 0; i < K; i++){
            result[i][0] = sorting.get(i)[0];
            result[i][1] = sorting.get(i)[1];
        }
        return  result;
    }
}
