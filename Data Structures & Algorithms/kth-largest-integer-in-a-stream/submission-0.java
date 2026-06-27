class KthLargest {
  List<Integer> li;
  int k;

  public KthLargest(int k, int[] nums) {
    this.li = new ArrayList<>();
    this.k = k;

    for (int num : nums) {
      li.add(num);
    }
  }

  public int add(int val) {
    li.add(val);
    Collections.sort(li);
    return li.get(li.size()-k);
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */