class MinStack {
    Deque<Integer> stk;

    public MinStack() {
        stk = new ArrayDeque<>();    
    }
    
    public void push(int val) {
        stk.push(val);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        int mini = Integer.MAX_VALUE;
        for (int val : stk)
            mini = Math.min(mini, val);

        return mini;
    }
}
