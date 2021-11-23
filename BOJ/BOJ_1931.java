/* 회의실 배정 https://www.acmicpc.net/problem/1931
   각 회의가 겹치지 않게하여 최대한 사용할 수 있는 회의의 개수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        int[][] tasks = new int[number][2];
        int count = 0;
        int current = 0;

        for (int i = 0; i < tasks.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            tasks[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            tasks[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(tasks, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            else {
                return Integer.compare(o1[1], o2[1]);
            }
        }));

        for (int[] task : tasks) {
            if (current <= task[0]) {
                count++;
                current = task[1];
            }
        }
        System.out.println(count);
    }
}