import java.util.*;

public class Main {
    public static double calculate(String expression) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);

        Stack<Character> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        List<String> tokens = new ArrayList<>();

        // 토큰화
        StringBuilder token = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                token.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
                tokens.add(String.valueOf(ch));
            } else if (Character.isWhitespace(ch)) {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
            } else {
                throw new IllegalArgumentException("Unexpected char: " + ch);
            }
        }
        if (token.length() > 0) {
            tokens.add(token.toString());
        }

        // 후위 표기법으로 변환
        for (String currentToken : tokens) {
            if (currentToken.matches("[0-9.]+")) {
                result.add(currentToken);
            } else {
                while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(currentToken.charAt(0))) {
                    result.add(String.valueOf(stack.pop()));
                }
                stack.push(currentToken.charAt(0));
            }
        }

        // 남은 연산자 처리
        while (!stack.isEmpty()) {
            result.add(String.valueOf(stack.pop()));
        }

        // 후위 표기법 계산
        Stack<Double> evalStack = new Stack<>();
        for (String item : result) {
            if (item.matches("[0-9.]+")) {
                evalStack.push(Double.parseDouble(item));
            } else {
                double b = evalStack.pop();
                double a = evalStack.pop();
                switch (item.charAt(0)) {
                    case '+':
                        evalStack.push(a + b);
                        break;
                    case '-':
                        evalStack.push(a - b);
                        break;
                    case '*':
                        evalStack.push(a * b);
                        break;
                }
            }
        }

        return evalStack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        String[] expressions = input.split(" ");

        double result1 = calculate(expressions[0]);
        double result2 = calculate(expressions[1]);

        double maxResult = Math.max(result1, result2);
        System.out.println((long) maxResult);
    }
}
