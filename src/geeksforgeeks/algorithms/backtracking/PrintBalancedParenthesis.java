package geeksforgeeks.algorithms.backtracking;

public class PrintBalancedParenthesis {
    private static void printBalancedParenthesisRecursive(int n, char[] str, int index, int left, int right,
            char openingBracket, char closingBracket) {
        if (right == n) {
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }

        if (left > right) {
            str[index] = closingBracket;
            printBalancedParenthesisRecursive(n, str, index + 1, left, right + 1, openingBracket, closingBracket);
        }
        if (left < n) {
            str[index] = openingBracket;
            printBalancedParenthesisRecursive(n, str, index + 1, left + 1, right, openingBracket, closingBracket);
        }
    }

    public static void printBalancedParenthesis(int n, String bracketType) {
        if (n == 0)
            return;

        char[] str = new char[n * 2];

        switch (bracketType) {
            case "PARENTHESIS":
                printBalancedParenthesisRecursive(n, str, 0, 0, 0, '(', ')');
                break;

            case "CURLY":
                printBalancedParenthesisRecursive(n, str, 0, 0, 0, '{', '}');
                break;

            case "SQUARE":
                printBalancedParenthesisRecursive(n, str, 0, 0, 0, '[', ']');
                break;

            default:
                printBalancedParenthesisRecursive(n, str, 0, 0, 0, '(', ')');
                break;
        }
    }

    public static void printBalancedParenthesis(int n) {
        printBalancedParenthesis(n, "PARENTHESIS");
    }

    public static void main(String[] args) {
        printBalancedParenthesis(3, "SQUARE");
    }
}
