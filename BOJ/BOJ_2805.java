/* 나무 자르기 https://www.acmicpc.net/problem/2805
   상근이가 필요한 만큼의 나무를 가져갈 수 있게 필요한 양만큼의 M이 최솟값이 되는 잘라야하는 길이를 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_2805 {
    static int stoi(String str) {
        return (Integer.parseInt(str));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        long[] woods = new long[N];
        st = new StringTokenizer(br.readLine());
        long head = 0;
        long tail = 0;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            if (tail < woods[i]) tail = woods[i];
        }

        while (head <= tail) {
            long mid = (head + tail) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) if(woods[i] >= mid) sum += woods[i] - mid;
            if (sum < M) tail = mid - 1;
            else {
                answer = mid;
                head = mid + 1;
            }
        }
        System.out.println(answer);
    }
}