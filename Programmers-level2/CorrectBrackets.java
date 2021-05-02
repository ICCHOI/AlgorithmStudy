/* 올바른 괄호(Correct Parentheses) https://programmers.co.kr/learn/courses/30/lessons/12909
   '('와 ')'로만 이루어진 String 배열이 주어질 때 괄호가 바르게 짝지어졌다면 true, 아니면 false를 반환하시오.
 */
import java.util.Stack;

class CorrectBrackets {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        stack.push('0');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }

        stack.pop();
        if (!stack.empty()) answer = false;

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        CorrectBrackets solve = new CorrectBrackets();
//        System.out.println(solve.solution("()()"));
//        System.out.println(solve.solution("(())()"));
//        System.out.println(solve.solution(")()("));
//        System.out.println(solve.solution("(()("));
//
//    }
//}