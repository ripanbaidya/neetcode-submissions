class Pair {
  int val;
  int minVal;

  public Pair(int val, int minVal) {
    this.val = val;
    this.minVal = minVal;
  }
}

class MinStack {
  List<Pair> li;

  public MinStack() {
    li = new ArrayList<>();
  }

  public void push(int value) {
    Pair top = li.size() == 0 ? new Pair(value, value) : li.get(li.size()-1);
    int val = top.val;
    int minVal = top.minVal;

    int newMini = minVal;
    if (value <= minVal) {
      newMini = value;
    }    
    li.add(new Pair(value, newMini));
  } 

  public void pop() {
    Pair pop = li.remove(li.size()-1);
  }

  public int top() {
    return li.get(li.size()-1).val;
  }

  public int getMin() {
    return li.get(li.size()-1).minVal;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */