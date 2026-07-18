class Pair {
  String lock;
  int moveCnt;

  public Pair(String lock, int moveCnt) {
    this.lock = lock;
    this.moveCnt = moveCnt;
  }
}

class Solution {
  public int openLock(String[] deadends, String target) {
    HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));

    if (target.equals("0000"))
      return 0;
    if (deadSet.contains(target) || deadSet.contains("0000"))
      return -1;

    Queue<Pair> que = new ArrayDeque<>();
    HashSet<String> vis = new HashSet<>();

    que.offer(new Pair("0000", 0));
    vis.add("0000");

    while (!que.isEmpty()) {
      Pair pair = que.poll();
      String currLock = pair.lock;
      int currMoveCnt = pair.moveCnt;

      if (currLock.equals(target))
        return currMoveCnt;

      // generate all 8 combinations
      for (int i = 0; i < 4; i++) {
        char[] lockArr = currLock.toCharArray();
        char originalChar = lockArr[i];

        // option A: Rotate wheel forward (+1)
        char forward = (originalChar == '9') ? '0' : (char) (originalChar + 1);
        lockArr[i] = forward;
        String nextForward = new String(lockArr);

        if (!deadSet.contains(nextForward) && !vis.contains(nextForward)) {
          vis.add(nextForward);
          que.offer(new Pair(nextForward, currMoveCnt + 1));
        }

        // option B: Rotate wheel backward (-1)
        char backward = (originalChar == '0') ? '9' : (char) (originalChar - 1);
        lockArr[i] = backward;
        String nextBackward = new String(lockArr);

        if (!deadSet.contains(nextBackward) && !vis.contains(nextBackward)) {
          vis.add(nextBackward);
          que.offer(new Pair(nextBackward, currMoveCnt + 1));
        }
      }
    }

    return -1;
  }
}