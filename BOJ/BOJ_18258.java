/* 큐 2 https://www.acmicpc.net/problem/18258
   push X, pop, size, empty, front(peek), back (print last of que)
   위의 명령들을 수행하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int lastInput = 0;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String op = st.nextToken();
            switch (op) {
                case "push":
                    lastInput = Integer.parseInt(st.nextToken());
                    queue.add(lastInput);
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(lastInput).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
