class MedianFinder {
  private PriorityQueue<Integer> left; // maxHeap
  private PriorityQueue<Integer> right; // minHeap

  public MedianFinder() {
    left = new PriorityQueue<>(Collections.reverseOrder());
    right = new PriorityQueue<>();
  }

  // left <= right
  public void addNum(int num) {
    if (left.size() == right.size()) {
      if (left.size() == 0 && right.size() == 0) {
        left.offer(num);
        return;  
      }

      left.offer(num);
      while (!(left.peek() <= right.peek())) {
        swap(left.poll(), right.poll());
      }
    }
    // left side has 1 element extra, add new element to the right side
    else if (left.size() - right.size() == 1) {
      right.offer(num);
      
      while (!(left.peek() <= right.peek())) {
        swap(left.poll(), right.poll());
      }
    }
  }

  public double findMedian() {
    int n = left.size() + right.size();
    if (n % 2 == 1)
      return left.peek();
    else
      return (left.peek() + right.peek()) / 2.0;
  }

  private void swap(int leftTop, int rightTop) {
    left.offer(rightTop);
    right.offer(leftTop);
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */