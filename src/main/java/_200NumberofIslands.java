import java.util.*;

public class _200NumberofIslands {
    public static void main(String[] args){
        _200NumberofIslands test = new _200NumberofIslands();
        char[][] grid = new char[][]{new char[]{'1','1','1','1','0'},
                new char[]{'1','1','0','1','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','0','0','0'}};
        System.out.println(test.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        Map<String, Integer> posToIsland = new LinkedHashMap<>();
        Map<Integer, List<String>> islandToPos = new LinkedHashMap<>();
        Integer landNum = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1') {//land!!

                    //上面有陆地
                    if(i > 0 && grid[i-1][j] == '1'){
                        Integer oldLand = posToIsland.get((i-1)+"+"+j);
                        posToIsland.put(i+"+"+j, oldLand);
                        List<String> posList = islandToPos.get(oldLand);
                        posList.add(i+"+"+j);
                    }

                    //左边有陆地
                    if(j > 0 && grid[i][j-1] == '1'){

                        //上边也有，左上连起来
                        if(posToIsland.containsKey(i+"+"+j)){//connect horizontal and vertical land
                            //当前位置已经在第一个if条件语句内和上边连起来
                            Integer upLand = posToIsland.get(i+"+"+j);
                            //把左边和上边连起来
                            Integer leftLand = posToIsland.get(i+"+"+(j-1));
                            if(!leftLand.equals(upLand)){
                                List<String> upPosList = islandToPos.get(upLand);
                                List<String> leftPosList = islandToPos.get(leftLand);
                                for(String leftEach: leftPosList){
                                    posToIsland.put(leftEach, upLand);
                                    upPosList.add(leftEach);
                                }
                                islandToPos.remove(leftLand);
                            }
                        }else{//上边没有陆地，只和左边连起来
                            Integer oldLand = posToIsland.get(i+"+"+(j-1));
                            posToIsland.put(i+"+"+j, oldLand);
                            List<String> posList = islandToPos.get(oldLand);
                            posList.add(i+"+"+j);
                        }
                    }

                    //左和上都没有陆地(之前的分支若任意一个成立，都会在posToIsland新建一个节点)，新建一个岛
                    if(!posToIsland.containsKey(i+"+"+j)){
                        Integer newLand = new Integer(landNum++);
                        posToIsland.put(i+"+"+j, newLand);
                        List<String> posList = new LinkedList<>();
                        posList.add(i+"+"+j);
                        islandToPos.put(newLand, posList);
                    }
                }
            }
        }

        return islandToPos.size();
    }
}
