class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        int[] st = new int[n+1]; // shortest time
        Arrays.fill(st, Integer.MAX_VALUE);
        st[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int ct = top[0], cn = top[1];

            if (ct > st[cn])
                continue;

            for (int[] nei : adj.get(cn)) {
                int nn = nei[0], nt = nei[1];
                if (st[nn] > ct + nt) {
                    st[nn] = ct + nt;
                    pq.offer(new int[] {st[nn], nn});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n+1; i ++) {
            ans = Math.max(ans, st[i]);

            if (st[i] == Integer.MAX_VALUE)
                return -1;
            
        }

        return ans;
    }
}
