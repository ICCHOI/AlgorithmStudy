/* 약수의 합 2 https://www.acmicpc.net/problem/17427
   자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
   자연수 N이 주어졌을 때, g(N)을 구해보자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DivisorSum {
    static long checkDivisor(int num) {
        long sum = 0L;
        for (int i = 1; i <= num; i++)
            sum += (long)i * (num / i);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(checkDivisor(Integer.parseInt(bf.readLine())));
    }
}