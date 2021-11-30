/* 가장 긴 증가하는 부분 수열 https://www.acmicpc.net/problem/11053
   배열내에서 최장 증가 부분 수열(LIS)의 길이를 구하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] inputNumbers = new int[number];
        int[] ascNumbers = new int[number];
        int max = 1;

        for (int i = 0; i < number; i++){
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < number; i++) {
            ascNumbers[i] = 1;
            for (int j = 0; j < i; j++){
                if (inputNumbers[j] < inputNumbers[i]) {
                    ascNumbers[i] = Math.max(ascNumbers[i], ascNumbers[j] + 1);
                }
                if (ascNumbers[i] > max) max = ascNumbers[i];
            }
        }
        System.out.println(max);
    }
}
