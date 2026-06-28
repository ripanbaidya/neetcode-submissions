class Solution {

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> nextValid = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
            nextValid.put(task, 0);
        }

        int time = 0;
        int remaining = tasks.length;

        while (remaining > 0) {

            Character chosen = null;

            // Scan every task
            for (char task : freq.keySet()) {

                if (freq.get(task) == 0)
                    continue;

                // still cooling down
                if (time < nextValid.get(task))
                    continue;

                // choose the task with maximum frequency
                if (chosen == null ||
                        freq.get(task) > freq.get(chosen)) {

                    chosen = task;
                }
            }

            if (chosen != null) {

                freq.put(chosen, freq.get(chosen) - 1);

                nextValid.put(chosen, time + n + 1);

                remaining--;
            }

            time++;
        }

        return time;
    }
}