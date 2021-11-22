/* 최소 힙 https://www.acmicpc.net/problem/1927
   int형 자연수를 입력받고, 0을 입력받을 떄는 가장 작은 값을 출력하고 그 수를 제거하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (input == 0) {
                if (queue.isEmpty()) stringBuilder.append("0\n");
                else stringBuilder.append(queue.poll()).append('\n');
            }
            else queue.add(input);
        }
        System.out.print(stringBuilder);
    }
}