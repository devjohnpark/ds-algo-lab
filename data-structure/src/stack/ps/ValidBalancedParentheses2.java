package stack.ps;

import java.util.Stack;

public class ValidBalancedParentheses2 {
    public static char[][] pairParentheses = { {'{', '}'}, {'(', ')'}, {'[', ']'} };

    public static boolean isBalanced(String tokens) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < tokens.length(); i++) {
            char c = tokens.charAt(i);
            if (isOpenParentheses(c)) {
                stack.push(c);
            } else if (isCloseParentheses(c)) {
                if (stack.isEmpty() || !isPairParentheses(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isPairParentheses(char openParentheses, char closeParentheses) {
        for (char[] pairs: pairParentheses) {
            if (openParentheses == pairs[0] && closeParentheses == pairs[1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCloseParentheses(char c) {
        for (char[] pair : pairParentheses) {
            if (c == pair[1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOpenParentheses(char c) {
         for (char[] pair : pairParentheses) {
             if (c == pair[0]) {
                 return true;
             }
         }
         return false;
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
