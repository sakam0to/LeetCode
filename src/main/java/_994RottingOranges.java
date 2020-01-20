import java.util.LinkedHashSet;
import java.util.Set;

public class _994RottingOranges {
    public static void main(String[] args){
        _994RottingOranges solution = new _994RottingOranges();
        int[][] input1 = new int[3][3];
        input1[0] = new int[]{2,1,1};
        input1[1] = new int[]{1,1,0};
        input1[2] = new int[]{0,1,1};
        System.out.println(solution.orangesRotting(input1));
        int[][] input2 = new int[1][2];
        input2[0] = new int[]{0,2};
        System.out.println(solution.orangesRotting(input2));
    }

    public int orangesRotting(int[][] grid) {
        //两个Set 存放rotten和fresh
        Set<Integer> rotten = new LinkedHashSet<>();
        Set<Integer> fresh = new LinkedHashSet<>();

        //初始化
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] >= 2){
                    rotten.add(Integer.valueOf(i*grid[0].length + j));
                }else if(grid[i][j] >= 1){
                    fresh.add(Integer.valueOf(i*grid[0].length + j));
                }
            }
        }

        //每分钟遍历一遍rotten中的元素，直到没有新rotten的元素为止
        boolean isRotten = !rotten.isEmpty();
        int minute = 0;
        while (isRotten){
            Set<Integer> newRotten = new LinkedHashSet<>();
            for(Integer index : rotten){
                int i = index / grid[0].length;
                int j = index % grid[0].length;

                if(i > 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2;
                    newRotten.add(Integer.valueOf(index - grid[0].length));
                    fresh.remove(Integer.valueOf(index - grid[0].length));
                }
                if(i < grid.length - 1 && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2;
                    newRotten.add(Integer.valueOf(index + grid[0].length));
                    fresh.remove(Integer.valueOf(index + grid[0].length));
                }
                if(j > 0 && grid[i][j - 1] == 1){
                    grid[i][j - 1] = 2;
                    newRotten.add(Integer.valueOf(index - 1));
                    fresh.remove(Integer.valueOf(index - 1));
                }
                if(j < grid[0].length - 1 && grid[i][j + 1] == 1){
                    grid[i][j + 1] = 2;
                    newRotten.add(Integer.valueOf(index + 1));
                    fresh.remove(Integer.valueOf(index + 1));
                }
            }
            rotten = newRotten;
            isRotten = !rotten.isEmpty();
            if(isRotten){
                minute++;
            }
        }

        if(!fresh.isEmpty())
            minute = -1;
        return minute;
    }

}

