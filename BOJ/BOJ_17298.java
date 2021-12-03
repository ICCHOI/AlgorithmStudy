/* 오큰수
   특정 인덱스의 오른쪽(인덱스 번호가 더 높은) 숫자들 중 인덱스 보다 높은 최소 거리 위치의 숫자를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int[] numbers = new int[number];
        int[] outputs = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = number - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= numbers[i])
                stack.pop();

            if (stack.empty()) outputs[i] = -1;
            else outputs[i] = stack.peek();

            stack.push(numbers[i]);
        }
        for (int i = 0; i < number; i++) stringBuilder.append(outputs[i]).append(' ');
        System.out.print(stringBuilder);
    }
}
