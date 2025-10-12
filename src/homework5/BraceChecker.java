package homework5;

import java.util.Stack;

public class BraceChecker {
    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack stack = new Stack();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);


            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                char last = (char) stack.pop();
                if (last == '\0') {
                    System.out.println("Error: closed " + c + " at " + i + " but nothing opened!");
                    continue;
                }
                if (!matches(last, c)) {
                    System.out.println("Error: opened " + last + " but closed " + c + " at " + i);
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: some braces ware not closed!");
        }else {
            System.out.println("All braces are correctly balanced");
        }
    }
    private boolean matches(char open,char close) {

        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}