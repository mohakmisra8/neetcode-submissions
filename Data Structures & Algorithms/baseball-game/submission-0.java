class Solution {
    public int calPoints(String[] operations) {
        // use a stack to initialise scores
        // if + add the sum of the top two
        // if it is d then double the top element
        // if it is c pop the top element
        Stack<Integer> stack = new Stack<>();

        for(String op: operations) {
            if(op.equals("+")) {
                int top = stack.pop();
                int newTop = top+stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2*stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int score:stack) {
            sum+=score;
        }

        return sum;
        

        
    }
}