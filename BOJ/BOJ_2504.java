/* 괄호의 값 https://www.acmicpc.net/problem/2504
   () = 2, [] = 3, (X) = 2 * X [X] = 3 * X (XY) = (X) + (Y)
   다음과 같을 때 () []로만 이루어진 문자열이 주어지면 값을 구해 출력하시오.
*/
import java.util.Scanner;
import java.util.Stack;

class BOJ_2504 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        input = input.replaceAll("\\(\\)", "2")
                .replaceAll("\\[]", "3");
        Stack<Integer> opStack = new Stack<>();
        boolean check = true;
        int temp = 0;

        for (int i = 0; i < input.length(); i++) {
            char checkChar = input.charAt(i);
            if (checkChar == '(' || checkChar == '[') {
                if (check) {
                    if (checkChar == '(') opStack.push(-2);
                    else opStack.push(-3);
                }
                else {
                    opStack.push(temp);
                    temp = 0;
                    if (checkChar == '(') opStack.push(-2);
                    else opStack.push(-3);
                    check = true;
                }
            }
            else if (checkChar == '2' || checkChar == '3') {
                opStack.push(checkChar - '0');
            }
            else if (checkChar == ')'){
                if (opStack.empty()) {
                    opStack.push(0);
                    break;
                }
                else {
                    while (!opStack.empty() && opStack.peek() > 0 ) {
                        if (!opStack.empty()) {
                            temp += opStack.pop();
                        }
                    }
                    if (!opStack.empty() && opStack.peek() == -2) {
                        opStack.pop();
                        temp *= 2;
                    }
                    else {
                        opStack.push(0);
                        break;
                    }
                }
                check = false;
            }
            else if (checkChar == ']') {
                if (opStack.empty()) {
                    opStack.push(0);
                    break;
                }
                else {
                    while (!opStack.empty() && opStack.peek() > 0 ) {
                        if (!opStack.empty()) {
                            temp += opStack.pop();
                        }
                    }
                    if (!opStack.empty() && opStack.peek() == -3) {
                        opStack.pop();
                        temp *= 3;
                    }
                    else {
                        opStack.push(0);
                        break;
                    }
                }
                check = false;
            }
            else {
                opStack.push(0);
                break;
            }
        }
        while(!opStack.empty()){
            if (opStack.peek() > 0) temp += opStack.pop();
            else break;
        }
        if (opStack.empty()) System.out.println(temp);
        else System.out.println(0);
    }
}
