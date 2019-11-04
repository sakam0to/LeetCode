import java.util.*;

public class Twitter_OA_3_Activate_Fountain {
    static int min;
    static boolean[] opened;
    static List<int[]> range;
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(5);
        a.add(4);
        a.add(1);
        a.add(1);
        a.add(3);
        a.add(0);
        a.add(6);
        a.add(3);
        a.add(5);
        a.add(3);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(2);
        a.add(0);
        a.add(0);
        a.add(4);

        /**Random random = new Random();
        for(int i =0; i< 20; i++){
            int e = random.nextInt(7);
            a.add(e);
            System.out.println(e);

        }*/
        System.out.println("The result: "+fountainActivation(a));

    }
    public static int fountainActivation2(List<Integer> a) {
        // Write your code here
        range = new ArrayList<>();
        min = a.size();
        opened = new boolean[a.size()];
        for(int i = 0; i < a.size(); i++){
            int start = Math.max(i-a.get(i), 0);
            int end = Math.min(i+a.get(i), a.size() - 1);
            int size = end - start + 1;
            range.add(new int[]{i, start, end, size});
        }
        Collections.sort(range, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[3] == o2[3]){
                    return 0;
                }else if(o1[3] < o2[3]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        activate(-1, 0, a.size());
        return min;

    }

    static void activate(int index, int open, int remaining){
        if(remaining == 0 && open < min){
            min = open;
        }
        if(remaining > 0 && open < min && (index + 1) < opened.length){
            opened[index + 1] = true;
            activate(index+1, open+1, getRemainNum());
            opened[index + 1] = false;
            activate(index+1, open, remaining);
        }
    }

    static int getRemainNum() {
        List<int[]> covered = new LinkedList<>();
        for(int i = 0; i < opened.length; i++){
            if(opened[i]){
                int start = range.get(i)[1];
                int end = range.get(i)[2];
                for(int j = 0; j < covered.size(); j++){
                    if(end < covered.get(j)[1]){
                        covered.add(j, new int[]{start, end});
                        break;
                    }else if((end >= covered.get(j)[0] && end <= covered.get(j)[1]) || (start >= covered.get(j)[0] && start <= covered.get(j)[1])){
                        covered.set(j, new int[]{Math.min(start, covered.get(j)[0]), Math.max(end, covered.get(j)[1])});
                        break;
                    }
                }
                covered.add(new int[]{start, end});
            }
        }
        int result = range.size();
        for(int[] b : covered){
            result -= b[1] - b[0] + 1;
        }
        return result;
    }


    public static int fountainActivation(List<Integer> a) {
        LinkedList<Integer> selected = new LinkedList<>();
        int bound = 0;
        for(int i = 0; i < a.size(); i++){
            int start = Math.max(i-a.get(i), 0);
            int end = Math.min(i+a.get(i), a.size() - 1);

            if(end > bound){
                bound = end;
                while(!selected.isEmpty()){
                    int last = selected.getLast();
                    int lastStart =  Math.max(last-a.get(last), 0);
                    boolean unchange = true;
                    if(start <= lastStart){
                        selected.removeLast();
                        unchange = false;
                    }else if(selected.size() >= 2) {
                        int last2 = selected.get(selected.size() - 2);
                        int last2End =  Math.min(last2+a.get(last2), a.size() - 1);
                        if( start - last2End <= 1){
                            selected.removeLast();
                            unchange = false;
                        }
                    }

                    if(unchange){
                        break;
                    }
                }
                selected.addLast(i);
            }
        }
        return selected.size();
    }
}