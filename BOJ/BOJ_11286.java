/* 절댓값 힙 https://www.acmicpc.net/problem/11286
   배열에 정수 x (x ≠ 0)를 넣는다. 0을 입력으로 받을 시, 절댓값이 가장 작은 값을 출력하고, 그 값을 제거한다.
   절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 제거한다.
   TC = N(1≤N≤100,000)이며 비어있을 때는 0을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueueR = new PriorityQueue<>(Collections.reverseOrder()); // -
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // +
        StringBuilder stringBuilder = new StringBuilder();

        int count = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (input > 0) {
                priorityQueue.add(input);
            }
            else if (input == 0) {
                if(priorityQueue.isEmpty()) {
                    if (priorityQueueR.isEmpty()) stringBuilder.append("0\n");
                    else stringBuilder.append(priorityQueueR.poll()).append('\n');
                }
                else {
                    if (priorityQueueR.isEmpty()) stringBuilder.append(priorityQueue.poll()).append('\n');
                    else {
                        int minus = priorityQueueR.poll();
                        int plus = priorityQueue.poll();
                        if (Math.abs(minus) == plus) {
                            stringBuilder.append(minus).append('\n');
                            priorityQueue.add(plus);
                        }
                        else {
                            if (plus > Math.abs(minus)) {
                                stringBuilder.append(minus).append('\n');
                                priorityQueue.add(plus);
                            } else {
                                stringBuilder.append(plus).append('\n');
                                priorityQueueR.add(minus);
                            }
                        }
                    }
                }
            }
            else {
                priorityQueueR.add(input);
            }
        }
        System.out.println(stringBuilder);
    }
}