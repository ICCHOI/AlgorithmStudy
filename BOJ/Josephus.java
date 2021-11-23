/* 요세푸스 문제 0 https://www.acmicpc.net/problem/11866
   요세푸스 순열을 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        int totalNum = Integer.parseInt(st.nextToken());
        int indexNum = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalNum; i++) {
            queue.add(i + 1);
        }
        sb.append('<');
        for (int i = 0; i < totalNum; i++) {
            for (int j = 0; j < indexNum; j++) {
                if (j == indexNum - 1) {
                    sb.append(queue.poll());
                }
                else {
                    int temp = queue.poll();
                    queue.add(temp);
                }
            }
            if (!(i == totalNum - 1)) sb.append(", ");
        }
        sb.append('>');
        System.out.println(sb);
    }
}