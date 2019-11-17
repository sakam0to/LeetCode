import java.util.Stack;

public class _150EvaluateReversePolishNotation {
    public static void main(String[] args){
        _150EvaluateReversePolishNotation test = new _150EvaluateReversePolishNotation();
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(test.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands  = new Stack<>();
        for(String token : tokens){
            if(token.matches("-?\\d+")){
                operands.add(Integer.valueOf(token));
            }else{
                Integer operand2 = operands.pop();
                Integer operand1 = operands.pop();
                Integer result = 0;
                if(token.matches("\\+")){
                    result = operand1 + operand2;
                }else if(token.matches("\\-")){
                    result = operand1 - operand2;
                }else if(token.matches("\\*")){
                    result = operand1 * operand2;
                }else {
                    result = operand1 / operand2;
                }

                operands.push(result);
            }
        }
        return operands.peek();
    }
}
