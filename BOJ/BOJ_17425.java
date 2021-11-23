/* 약수의 합 https://www.acmicpc.net/problem/17425
   자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
   x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
   T(1 ≤ T ≤ 100,000),  N(1 ≤ N ≤ 1,000,000)일때 g(N)을 한 줄에 하나씩 출력하시오.
 */
import java.io.*;

public class BOJ_17425 {
    static void putDivisor(int num, long[] fDivisors, long[] gDivisors) {
        for (int i = 1; i <= num; i++) {
            for (int j = i; j <= num; j+=i) {
                fDivisors[j - 1] += i;
            }
        }
        gDivisors[0] = 1;
        for (int i = 1; i < num; i++)
            gDivisors[i] = gDivisors[i - 1] + fDivisors[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int max = 0;
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
            if (numbers[i] > max) max = numbers[i];
        }

        long[] fDivisors = new long[max];
        long[] gDivisors = new long[max];
        putDivisor(max, fDivisors, gDivisors);

        for (int i : numbers) {
            sb.append(gDivisors[i - 1]).append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}