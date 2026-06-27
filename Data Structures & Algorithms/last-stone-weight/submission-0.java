class Solution {
  public int lastStoneWeight(int[] stones) {
    if (stones.length == 1)
      return stones[0];
    
    PriorityQueue<Integer> maxHeap = 
      new PriorityQueue<>(Collections.reverseOrder());

    // Put all the stone into the maxHeap
    for (int stone : stones) {
      maxHeap.offer(stone);
    }

    while (maxHeap.size() > 1) {
      int x = maxHeap.poll();
      int y = maxHeap.poll();

      if (x == y)  {
        // both stones are destroyed
      } else {
        // add new stone having weight (y-x)
        maxHeap.offer(Math.abs(y-x));
      }

      if (maxHeap.size() == 1)
        return maxHeap.peek();
    }

    return 0;
  }
}