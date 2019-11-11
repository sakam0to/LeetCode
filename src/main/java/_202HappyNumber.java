import java.util.*;

public class _202HappyNumber {
    public static void main(String[] args){
        _202HappyNumber test = new _202HappyNumber();
        System.out.println(test.isHappy(2));
    }
    public boolean isHappy(int n) {
        int sum = n;
        Set<Integer> records = new LinkedHashSet<>();
        while(!records.contains(sum)){
            records.add(sum);
            Integer[] digits = digit(sum);
            sum = 0;
            for(Integer i : digits){
                sum += i*i;
            }
        }

        if(sum == 1)
            return true;
        else
            return false;
    }

    private Integer[] digit(int n) {
        LinkedList<Integer> digits = new LinkedList<>();
        digits.addFirst(n%10);
        while(n >= 10){
            n = n/10;
            digits.addFirst(n%10);
        }
        return digits.toArray(new Integer[digits.size()]);
    }
}
