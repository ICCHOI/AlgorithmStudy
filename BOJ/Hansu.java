/* 한수 https://www.acmicpc.net/problem/1065
   어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면 그 수를 한수라고 합니다.
   (1 <= N <= 1000)이 주어졌을 때 (1 <= N)의 범위의 한수의 개수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Hansu {
    static boolean checkHansu(int num) {
        if ((num / 100) - ((num / 10) % 10) == ((num / 10) % 10) - (num % 10)) return true;
        else return (num % 10) - ((num / 10) % 10) == ((num / 10) % 10) - (num / 100);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        int count = 99;
        if(num < 100) System.out.println(num);
        else {
            for (int i = 100; i <= num; i++) if (checkHansu(i)) count++;
            System.out.println(count);
        }
    }
}
