class Twitter {
  private int time;
  private HashMap<Integer, Set<Integer>> followMap;
  // userId -> [ {tweetId, time}, {}, {}, ... ] 
  private HashMap<Integer, List<int[]>> tweetMap;

  public Twitter() {
    time = 0;
    followMap = new HashMap<>();
    tweetMap = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    tweetMap.putIfAbsent(userId, new ArrayList<>());
    tweetMap.get(userId).add(new int[] { tweetId, time++ });
  }

  public List<Integer> getNewsFeed(int userId) {
    int k = 10;
    // {tweetId, time}
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    // user's own tweet
    addRecentTweet(userId, minHeap, k);

    // tweet from the followee
    for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
      addRecentTweet(followeeId, minHeap, k);
    }

    // Heap gives tweets from oldest -> newest,
    // so insert at the beginning to reverse the order.
    List<Integer> res = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      res.add(0, minHeap.poll()[0]);
    }

    return res;
  }

  public void follow(int followerId, int followeeId) {
    // user can't follow himself
    if (followerId != followeeId) {
      followMap.putIfAbsent(followerId, new HashSet<>());
      followMap.get(followerId).add(followeeId);
    }
  }

  public void unfollow(int followerId, int followeeId) {
    followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
  }

  private void addRecentTweet(int userId, PriorityQueue<int[]> minHeap, int k) {
    for (int[] tweet : tweetMap.getOrDefault(userId, new ArrayList<>())) {
      if (minHeap.size() < k) {
        minHeap.offer(tweet);
      } else if (tweet[1] > minHeap.peek()[1]) {
        minHeap.poll();
        minHeap.offer(tweet);
      }
    }
  }
}
