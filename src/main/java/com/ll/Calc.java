package com.ll;

public class Calc {
    public static int run(String input) {
        String expr = input.replace(" ", "");

        for (int idx = expr.length() - 1; idx >= 0; idx--) {
            char op = expr.charAt(idx);

            if (isOperator(op)) {
                if ((op == '+' || op == '-') && (idx == 0 || isOperator(expr.charAt(idx - 1)))) {
                    continue;
                }

                String leftExpr = expr.substring(0, idx);
                String rightExpr = expr.substring(idx + 1);

                int leftVal = run(leftExpr);
                int rightVal = run(rightExpr);

                if (op == '+') return leftVal + rightVal;
                if (op == '-') return leftVal - rightVal;
                return leftVal * rightVal;
            }
        }
        return Integer.parseInt(expr);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}