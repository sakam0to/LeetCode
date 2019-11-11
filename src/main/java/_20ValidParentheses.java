import java.util.Stack;

public class _20ValidParentheses {
    public static void main(String[] args){
        _20ValidParentheses test = new _20ValidParentheses();
        System.out.println(test.isValid("(]"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c.equals('[')||c.equals('{')||c.equals('(')){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character old = stack.pop();
                if(old.equals('{') && !c.equals('}')){
                    return false;
                }
                if(old.equals('(') && !c.equals(')')){
                    return false;
                }
                if(old.equals('[') && !c.equals(']')){
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}