/* 나무 자르기 https://www.acmicpc.net/problem/2805

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class WoodCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int take = Integer.parseInt(st.nextToken());
        long[] woods = new long[number];
        st = new StringTokenizer(br.readLine());
        long head = 0;
        long tail = 0;
        for (int i = 0; i < number; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            if (tail < woods[i]) tail = woods[i];
        }
        long answer = 0;
        while (head <= tail) {
            long mid = (head + tail) / 2;
            long sum = 0;
            for (int i = 0; i < number; i++) if(woods[i] >= mid) sum += woods[i] - mid;
            if (sum < take) tail = mid - 1;
            else {
                answer = mid;
                head = mid + 1;
            }
        }
        System.out.println(answer);
    }
}