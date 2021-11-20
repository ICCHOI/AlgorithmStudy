/* 제로 https://www.acmicpc.net/problem/10773
   0이 나오면 스택에 pop, 그 외의 수는 스택에 push 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < num; i++) {
            int index = Integer.parseInt(bufferedReader.readLine());
            if (index != 0) {
                stack.push(index);
                sum += index;
            }
            else sum -= stack.pop();
        }
        System.out.println(sum);
    }
}
