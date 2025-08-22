import java.util.*;

class MinStack {
    private Deque<Integer> st = new ArrayDeque<>();
    private Deque<Integer> minSt = new ArrayDeque<>();

    public MinStack() {}

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty()) minSt.push(val);
        else minSt.push(Math.min(val, minSt.peek()));
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
