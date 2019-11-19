import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {
    public static void main(String[] args){
        _139WordBreak test = new _139WordBreak();
        String s = "applepenapple";
        String[] wordDict = new String[]{"apple", "pen"};
        System.out.println(test.wordBreak(s, Arrays.asList(wordDict)));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() < 1){
            return true;
        }
        char[] input = s.toCharArray();
        //states表示，以当前位置为终点，在此之前的子字符串是否能按照字典segmented
        boolean[] states = new boolean[input.length];

        Set<String> dict = new LinkedHashSet<>();
        for(String string: wordDict){
            dict.add(string);
        }

        for(int i = 1; i <= input.length; i++){
            //从当前位置倒推，如果states[j-1]为true，表示在0到j-1的子字符串可以segmented，
            //然后检查j到i的子字符串是否匹配字典，如果不匹配，则再后退一步继续检查
            //直到最后都不能找到匹配，就返回false。
            for(int j = i - 1; j >= 0; j--){
                if(j == 0 || states[j - 1]){
                    if(dict.contains(s.substring(j, i))){
                        states[i - 1] = true;
                        break;
                    }else{
                        states[i - 1] = false;
                    }
                }
            }
        }
        return states[states.length - 1];
    }
}
