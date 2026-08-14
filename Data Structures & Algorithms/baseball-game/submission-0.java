class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String op : operations) {
            switch(op) {
                case "+" -> {
                    int top = stk.pop();
                    int newTop = stk.peek();
                    stk.push(top);
                    stk.push(top + newTop);
                }
                case "D" -> {
                    stk.push(stk.peek() * 2);
                }
                case "C" -> {
                    stk.pop();
                }
                default -> stk.push(Integer.parseInt(op));
            }
        }
        
        int score = 0;
        while (!stk.isEmpty()) {
            score += stk.pop();
        }
        return score;
    }   
}