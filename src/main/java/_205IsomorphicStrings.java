import java.util.LinkedHashMap;
import java.util.Map;

public class _205IsomorphicStrings {
    public static void main(String[] args){
        _205IsomorphicStrings test = new _205IsomorphicStrings();
        String s = "egg";
        String t = "add";
        System.out.println(test.isIsomorphic(t, s));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> s2t = new LinkedHashMap<>();
        Map<Character, Character> t2s = new LinkedHashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        StringBuilder newS = new StringBuilder();
        StringBuilder newT = new StringBuilder();
        for(int i = 0; i < sChars.length; i++){
            if(s2t.containsKey(sChars[i])){
                newS.append(s2t.get(sChars[i]));
            }else{
                s2t.put(sChars[i], tChars[i]);
                newS.append(tChars[i]);
            }

            if(t2s.containsKey(tChars[i])){
                newT.append(t2s.get(tChars[i]));
            }else{
                t2s.put(tChars[i], sChars[i]);
                newT.append(sChars[i]);
            }
        }

        if(newS.toString().equals(t) && newT.toString().equals(s)){
            return true;
        }
        return false;
    }
}
