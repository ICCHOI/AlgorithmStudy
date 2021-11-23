/* 큐 https://www.acmicpc.net/problem/10828
   입력값을 입력받아 큐의 연산들을 수행하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class QueueCalc {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "pop":
                    System.out.println(queue.size() == 0 ? -1 : queue.poll());
                    break;
                case "empty":
                    System.out.println(queue.size() == 0 ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.size() == 0 ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.size() == 0 ? -1 : last);
                    break;
            }
        }
    }
}