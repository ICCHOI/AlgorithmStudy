/* 피보나치 수 https://www.acmicpc.net/problem/1003
   n번째 피보나치 수의 0이 출력되는 횟수와 1이 출력되는 횟수를 공백을 기준으로 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FibonacciNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        for (int j = 0; j < count; j++) {
            int number = Integer.parseInt(bf.readLine());
            if (number == 0) {
                System.out.println("1 0");
            } else {
                int[] fiboArray = new int[number + 1];

                fiboArray[0] = 0;
                fiboArray[1] = 1;

                for (int i = 2; i < number + 1; i++) {
                    fiboArray[i] = ((fiboArray[i - 1]) + (fiboArray[i - 2]));
                }
                System.out.printf("%d %d\n", fiboArray[number - 1], fiboArray[number]);
            }
        }
    }
}