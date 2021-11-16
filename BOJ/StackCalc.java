/* 스택 https://www.acmicpc.net/problem/10828
   입력값을 입력받아 스택의 연산들을 수행하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class StackCalc {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    System.out.println(stack.empty() ? -1 : stack.pop());
                    break;
                case "empty":
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.empty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}