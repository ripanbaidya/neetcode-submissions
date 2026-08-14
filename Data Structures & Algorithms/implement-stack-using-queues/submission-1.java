class MyStack {
  Queue<Integer> que;

  public MyStack() {
    que = new LinkedList<>();
  }

  public void push(int x) {
    que.offer(x);
    int n = que.size();

    for (int i = 1; i <= n-1; i ++) 
      que.offer(que.poll());
  }

  public int pop() {
    return que.poll();
  }

  public int top() {
    return que.peek();
  }

  public boolean empty() {
    return que.isEmpty();
  }
}
