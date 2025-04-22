package stack.ps;

import java.util.Stack;

public class ValidBalancedParentheses1 {

    public static boolean isBalanced(String tokens) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < tokens.length(); i++) {
            char c = tokens.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                // stack.peek()과 c 값비교해서 매칭되면 pop
                char top = stack.peek();
                if (top == '{' && c == '}') {
                    stack.pop();
                } else if (top == '(' && c == ')') {
                    stack.pop();
                } else if (top == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{")); // false
        System.out.println(isBalanced("}")); // false
        System.out.println(isBalanced("{()[]()()}")); // true
        System.out.println(isBalanced("{()[]()()")); // false
        System.out.println(isBalanced("()[]()()}")); // false
        System.out.println(isBalanced("{()[](]()}")); // false
    }
}
