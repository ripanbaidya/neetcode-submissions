class MedianFinder {
  private List<Integer> li;

  public MedianFinder() {
    li = new ArrayList<>();
  }

  public void addNum(int num) {
    li.add(num);
  }

  public double findMedian() {
    Collections.sort(li);
    int n = li.size();
    
    if (n % 2 == 1) 
      return li.get(n/2);
    else 
      return (li.get(n/2) + li.get(n/2-1)) / 2.0;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */