/* 옥상 정원 꾸미기 https://www.acmicpc.net/problem/6198
   i번째 빌딩의 키가 h(i)이고, 모든 빌딩은 일렬로 서 있고 오른쪽으로만 볼 수 있다.
   그러나 자신이 위치한 빌딩보다 높거나 같은 빌딩이 있으면 그 다음에 있는 모든 빌딩의 옥상은 보지 못한다. 빌딩 별 볼 수 있는 옥상의 수는?
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        long count = 0L;
        int[] inputNums = new int[number];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number; i++) {
            inputNums[i] = Integer.parseInt(br.readLine());
        }
        stack.push(number);

        for (int i = number - 1; i >= 0; i--) {
            while(!stack.empty()) {
                if(stack.peek() == number) {
                    count += number - i - 1;
                    break;
                }
                else if(inputNums[i] <= inputNums[stack.peek()]) {
                    count += stack.peek() - i - 1;
                    break;
                }
                else stack.pop();
            }
            stack.push(i);
        }
        System.out.print(count);
    }
}
