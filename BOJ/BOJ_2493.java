/* 탑 https://www.acmicpc.net/problem/2493
   자신의 현재 위치를 기준으로 왼쪽 방향에 자신보다 큰 수가 있으면,
   처음 나온 큰 수의 위치(1부터 시작)를 출력하시오. 없다면 0을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] length = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for (int i = 0; i < num; i++) {
            while(!stack.empty()) {
                if (length[stack.peek()] > length[i]) {
                    sb.append(stack.peek() + 1).append(' ');
                    break;
                }
                else stack.pop();
                if (stack.empty()) sb.append(0).append(' ');
            }
            stack.push(i);
        }
        System.out.print(sb);
    }
}
