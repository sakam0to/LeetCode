import java.util.*;

public class _118PascalsTriangle {
    public static void main(String[]  args){
        _118PascalsTriangle solution = new _118PascalsTriangle();
        solution.generate(2);
    }

    public List<List<Integer>> generate(int numRows) {
        Integer[] newRow = null;
        List<List<Integer>> generated = null;
        if(numRows == 1){
            newRow = new Integer[]{1};
            generated = new LinkedList<>();
        } else{
            generated = generate(numRows - 1);
            List<Integer> last = generated.get(generated.size() - 1);
            newRow = new Integer[last.size() + 1];
            for(int i = 0; i < last.size(); i++){
                newRow[i] = (newRow[i] == null)? last.get(i) : last.get(i) + newRow[i];
                newRow[i+1] = (newRow[i+1] == null)? last.get(i) : last.get(i) + newRow[i+1];
            }
        }
        List<Integer> newlist = Arrays.asList(newRow);
        generated.add(newlist);
        return generated;
    }
}
