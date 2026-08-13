class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stk.pop();
                int a = stk.pop();

                switch (token) {
                    case "+" -> stk.push(a + b);
                    case "-" -> stk.push(a - b);
                    case "*" -> stk.push(a * b);
                    case "/" -> stk.push(a / b);
                }
            } else {
                stk.push(Integer.parseInt(token));
            }
        }

        return stk.peek();
    }

    private boolean isOperator(String token) {
        String[] operators = {"+", "-", "*", "/"};
        for (String operator : operators) {
            if (token.equals(operator))
                return true;
        }

        return false;
    }
}