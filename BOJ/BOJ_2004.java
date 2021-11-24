/* 조합 0의 개수 https://www.acmicpc.net/problem/2004
   n choose m의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_2004 {
    static long divideTwo(long num){
        long count = 0L;
        long two = 2L;
        while (two <= num) {
            count += num / two;
            two *= 2L;
        }
        return count;
    }

    static long divideFive(long num){
        long count = 0L;
        long five = 5L;
        while (five <= num) {
            count += num / five;
            five *= 5L;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        long c = a - b;

        long[] countTwoAndFive = new long[2];

        countTwoAndFive[0] = divideTwo(a) - (divideTwo(b) + divideTwo(c));
        countTwoAndFive[1] = divideFive(a) - (divideFive(b) + divideFive(c));

        System.out.println(Math.min(countTwoAndFive[0], countTwoAndFive[1]));
    }
}