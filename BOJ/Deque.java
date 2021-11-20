/* 디큐 https://www.acmicpc.net/problem/10828
   입력값을 입력받아 큐의 연산들을 수행하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        java.util.Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            switch (temp) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "pop_front":
                    System.out.println(deque.size() == 0 ? -1 : deque.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.size() == 0 ? -1 : deque.pollLast());
                    break;
                case "empty":
                    System.out.println(deque.size() == 0 ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.size() == 0 ? -1 : deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.size() == 0 ? -1 : deque.peekLast());
                    break;
            }
        }
    }
}