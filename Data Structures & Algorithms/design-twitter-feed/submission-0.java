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
        tweetMap.get(userId).add(new int[]{tweetId, time ++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));

        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a, b) -> b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < Math.min(10, feed.size()); i ++) {
            res.add(feed.get(i)[0]);
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
}
