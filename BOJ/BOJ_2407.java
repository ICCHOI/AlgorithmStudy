/* 조합 https://www.acmicpc.net/problem/2407
   nCm을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

class BOJ_2407 {
    static BigDecimal calcFacto(BigDecimal factorial, int number, int totalNum, int lowNum){
        for (int i = number + 1; i <= totalNum; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        for (int i = 1; i <= lowNum; i++) {
            factorial = factorial.divide(BigDecimal.valueOf(i));
        }

        return factorial;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int totalNum = Integer.parseInt(stringTokenizer.nextToken());
        int takeNum = Integer.parseInt(stringTokenizer.nextToken());
        int subNum = totalNum - takeNum;
        BigDecimal factorial = BigDecimal.valueOf(1);

        if (takeNum > subNum) {
            System.out.println(calcFacto(factorial, takeNum, totalNum, subNum).toPlainString());
        }
        else {
            System.out.println(calcFacto(factorial, subNum, totalNum, takeNum).toPlainString());
        }
    }
}