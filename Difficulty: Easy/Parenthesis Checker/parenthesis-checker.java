import java.util.*;

class Solution {
    public boolean isBalanced(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {

            // Step 1: push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                // Step 2: check empty
                if(st.isEmpty()) return false;

                char top = st.pop();

                // Step 3: match pairs
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 4: final check
        return st.isEmpty();
    }
}