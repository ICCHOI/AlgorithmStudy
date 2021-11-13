/* 랜선 자르기 https://www.acmicpc.net/problem/1654
   랜선의 개수 K, 필요한 랜선의 개수 N이 주어질 때 (1 <= K <= 10,000, 1 <= N <= 1,000,000) K개의 랜선을 각각 가틍ㄴ
   길이로 잘라 나올 수 있는 N개의 랜선의 최대 길이를 구하시오. 단, K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class LanSlice {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int cur = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());
        int[] lan = new int[cur];
        long tail = 1;
        long front = 1;
        int count;
        for (int i = 0; i < cur; i++) {
            lan[i] = Integer.parseInt(bf.readLine());
            if (tail < lan[i]) tail = lan[i];
        }
        long length;
        int answer = 0;
        while (front <= tail) {
            count = 0;
            length = (front + tail) / 2;
            for (int i = 0; i < cur; i++) count += lan[i] / length;
            if(count < need) tail = length - 1;
            else {
                front = length + 1;
                answer = (int) length;
            }
        }
        System.out.println(answer);
    }
}
