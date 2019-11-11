import java.util.HashMap;
import java.util.LinkedHashMap;

public class _953VerifyinganAlienDictionary {
    public static void main(String[] args){
        _953VerifyinganAlienDictionary test = new _953VerifyinganAlienDictionary();
        String[] words = new String[]{"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(test.isAlienSorted(words, order));
    }
    public boolean isAlienSorted(String[] words, String order) {
        //order -> HashMap : character -> order
        HashMap<Character, Integer> dict = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < order.length(); i++){
            dict.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++){
            String min = words[i];
            String max = words[i + 1];
            if(!compareByDict(min, max, dict)){
                return false;
            }
        }
        return true;
    }

    private boolean compareByDict(String min, String max, HashMap<Character, Integer> dict) {
        boolean hasCommonPrefix = true;
        for(int i = 0; i < Math.min(min.length(), max.length()); i++){
            char minChar = min.charAt(i);
            char maxChar = max.charAt(i);
            if(minChar != maxChar){
                hasCommonPrefix = false;//If min and max has common prefix?
                if(dict.get(minChar) > dict.get(maxChar)){
                    return false;
                }else{
                    return true;
                }
            }
        }

        if(hasCommonPrefix && min.length() > max.length()){//eg. min='ab', max='abc' -> false
            return false;
        }
        return true;
    }
}
