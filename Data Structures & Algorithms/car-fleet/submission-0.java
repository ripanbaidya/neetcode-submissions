class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i ++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }  

        // Sort in ASC based on position
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Deque<Double> stk = new ArrayDeque<>();

        for (int[] p : pair) {
            // Time take to reach target
            double time = (double)(target - p[0]) / p[1];
          
            if (stk.isEmpty() || time > stk.peek()) {
                stk.push(time);
            }
        }

        return stk.size();
    }
}
