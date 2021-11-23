/* 2×n 타일링 2 https://www.acmicpc.net/problem/11727
   2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
   n (1 ≤ n ≤ 1,000) 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 */
import java.util.Scanner;

class BOJ_11727 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        System.out.println(tileCalc(number));
    }

    static int tileCalc(int number) {
        int[] array = new int[number];
        array[0] = 1;
        if(array.length != 1) array[1] = 3;

        for (int i = 2; i < number; i++) array[i] = (array[i - 1] + (2 * array[i - 2])) % 10007;

        return array[number - 1];
    }
}