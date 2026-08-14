class MyStack {
    Deque<Integer> que;
    public MyStack() {
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.offer(x);
    }
    
    public int pop() {
        // 1 2 3
        for (int i = 1; i <= que.size()-1 ; i ++) {
            int val = que.poll();
            que.offer(val);
        }
        return que.poll();
    }
    
    public int top() {
        return que.peekLast();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */