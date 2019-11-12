import java.util.LinkedHashMap;
import java.util.Map;

public class _387FirstUniqueCharacterinaString {
    public static void main(String[] args){
        _387FirstUniqueCharacterinaString test = new _387FirstUniqueCharacterinaString();
        System.out.println(test.firstUniqChar("aadadaad"));
    }
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        char[] input = s.toCharArray();
        for(int i = 0; i < input.length; i++){
            if(map.containsKey(input[i])){
                map.put(input[i], input.length);//重复字符可能有很多，为了解决这个问题，将重复字符的位置设为出界
            }else{
                map.put(input[i], i);
            }
        }

        int first = -1;
        for(Character c : map.keySet()){
            if(map.get(c) < input.length){
                if(first < 0 || map.get(c) < first){
                    first = map.get(c);
                }
            }
        }
        return first;
    }
}
