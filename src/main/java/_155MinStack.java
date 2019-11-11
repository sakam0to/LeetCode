import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _155MinStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    LinkedList<Integer[]> stack; //the stack stores value from small to big. int[0] = val, int[1] = order;
    int topPointer;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        topPointer = -1;
    }

    public void push(int x) {
        Iterator<Integer[]> iterator = stack.iterator();
        int index = 0;
        while(iterator.hasNext()){
            if(iterator.next()[0] > x){
                break;
            }
            index++;
        }
        stack.add(index, new Integer[]{x, ++topPointer});
    }

    public void pop() {
        if(stack.size() > 0 && topPointer >= 0){
            Iterator<Integer[]> iterator = stack.iterator();
            int index = 0;
            while(iterator.hasNext()){
                if(iterator.next()[1] == topPointer){
                    topPointer--;
                    break;
                }
                index++;
            }
            stack.remove(index);
        }
    }

    public int top() {
        int top = -1;
        if(stack.size() > 0 && topPointer >= 0){
            Iterator<Integer[]> iterator = stack.iterator();
            int index = 0;
            while(iterator.hasNext()){
                if(iterator.next()[1] == topPointer){
                    break;
                }
                index++;
            }
            top = stack.get(index)[0];
        }
        return top;
    }

    public int getMin() {
        return stack.getFirst()[0];
    }
}

