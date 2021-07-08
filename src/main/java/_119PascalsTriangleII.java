import java.util.*;

public class _119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> result = new ArrayList();
            result.add(1);
            return result;
        }

        List<Integer> result = getRow(rowIndex - 1);
        result.add(result.get(result.size() - 1));
        for(int i = result.size() - 3; i >= 0; i--){
            result.set(i+1, result.get(i) + result.get(i+1));
        }
        return result;
    }
}
