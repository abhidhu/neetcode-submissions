class Solution {
    public int evalRPN(String[] tokens) {
        // Use Deque as a Stack (Standard Java practice)
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            // Check if the token is an operator
            if ("+-*/".contains(token) && token.length() == 1) {
                // The first pop is the RIGHT operand
                int b = stack.pop();
                // The second pop is the LEFT operand
                int a = stack.pop();
                
                stack.push(doOperation(a, b, token));
            } else {
                // If it's not an operator, it's a number (handles negatives too)
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int doOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
}