class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // open brace
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }

            // close bracket
            else {
                if (!st.isEmpty() && checkPair(st.peek(), c))
                    st.pop();
                else
                    return false;
            }
        }

        return st.isEmpty();
    }

    private boolean checkPair(char open, char close) {
        return (open == '(' && close == ')') 
            || (open == '{' && close == '}')
            || (open == '[' && close == ']');
    }
}