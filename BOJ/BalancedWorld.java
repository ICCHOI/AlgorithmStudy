/* 균형잡힌 세상 https://www.acmicpc.net/problem/4949
   모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다, 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
   모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다, 모든 괄호들의 짝은 1:1 매칭만 가능하다. 마지막 줄 '.'를 종료로 받는다.
   짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다. 줄마다 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        while ((input = bf.readLine()) != null) {
            if (input.length() == 1 && input.charAt(0) == '.') break;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '[' || input.charAt(i) == '(') stack.push(input.charAt(i));
                else if (input.charAt(i) == ']') {
                    if (stack.size() == 0) {
                        stack.push('b');
                        break;
                    }
                    else if (stack.peek() == '[') stack.pop();
                    else {
                        stack.push('b');
                        break;
                    }
                }
                else if (input.charAt(i) == ')') {
                    if (stack.size() == 0) {
                        stack.push('b');
                        break;
                    }
                    else if (stack.peek() == '(') stack.pop();
                    else {
                        stack.push('b');
                        break;
                    }
                }
                else if (input.charAt(i) == '.') break;
            }
            if (stack.empty()) stringBuilder.append("yes").append('\n');
            else stringBuilder.append("no").append('\n');
            stack.clear();
        }
        System.out.println(stringBuilder);
    }
}