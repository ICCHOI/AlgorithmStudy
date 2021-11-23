/* 괄호 https://www.acmicpc.net/problem/9012
   '('과 ')'로 매칭하여 올바르게 구성된 괄호 문자열이면 YES 아니면 NO를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int number = Integer.parseInt(bf.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') stack.push(input.charAt(j));
                else if (input.charAt(j) == ')') {
                    if (stack.size() == 0) {
                        stack.push('b');
                        break;
                    } else if (stack.peek() == '(') stack.pop();
                }
            }
            if (stack.empty()) stringBuilder.append("YES").append('\n');
            else stringBuilder.append("NO").append('\n');
            stack.clear();
        }
        System.out.println(stringBuilder);
    }
}