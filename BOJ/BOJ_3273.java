/* 두 수의 합 https://www.acmicpc.net/problem/3273
   ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하시오.
    (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(bf.readLine());
        StringTokenizer tokens = new StringTokenizer(bf.readLine());
        int targetNum = Integer.parseInt(bf.readLine());
        boolean[] checkNumbers = new boolean[100000];
        int[] inputNumbers = new int[inputCount];
        int count = 0;

        for (int i = 0; i < inputCount; i++) {
            inputNumbers[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < inputCount; i++) {
            if(inputNumbers[i] > 100000 || inputNumbers[i] < 1) continue;
            checkNumbers[inputNumbers[i] - 1] = true;
        }

        for (int i = 0; i < inputCount; i++) {
            if (targetNum - inputNumbers[i] > 100000 || targetNum - inputNumbers[i] < 1) continue;

            if (checkNumbers[targetNum - inputNumbers[i] - 1]) {
                count++;
            }
        }
        System.out.println(count / 2);
    }
}
