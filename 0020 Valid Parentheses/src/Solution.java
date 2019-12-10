import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == '(' || charAt == '[' || charAt == '{') {
                stack.push(charAt);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char popped = stack.pop();
                if ((charAt == ')' && popped != '(') || (charAt == ']' && popped != '[') || (charAt == '}' && popped != '{')) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
