import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        helper(current, n, n, sol);
        return sol;
    }
    private void helper(StringBuilder current, int open, int close, List<String> solution) {
        if (open == 0) {
            if (close == 0) {
                solution.add(current.toString());
                return;
            } else {
                for (int i = 0; i < close; i++) {
                    current.append(')');
                }
                solution.add(current.toString());
                return;
            }
        }
        if (open == close) {
            current.append('(');
            open -= 1;
            helper(current, open, close, solution);
        } else {
            StringBuilder copy = new StringBuilder(current);
            current.append('(');
            open -= 1;
            helper(current, open, close, solution);
            open += 1;
            copy.append(')');
            close -= 1;
            helper(copy, open, close, solution);
        }
    }
}
