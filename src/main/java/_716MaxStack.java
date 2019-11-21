import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class _716MaxStack {
    public static void main(String[] args){
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}

class MaxStack {
    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int result = o1-o2;
            if(result > 0){
                return -1;
            }
            if(result < 0){
                return 1;
            }
            return result;
        }
    });
    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        heap.add(x);
    }

    public int pop() {
        int result = stack.pop();
        heap.remove(result);
        return result;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return heap.peek();
    }

    public int popMax() {
        Integer max = heap.poll();
        Stack<Integer> temp = new Stack<>();
        while(!stack.peek().equals(max)){
            temp.push(stack.pop());
        }
        stack.pop();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return max;
    }
}