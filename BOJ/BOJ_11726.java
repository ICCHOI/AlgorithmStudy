/* 2×n 타일링 https://www.acmicpc.net/problem/11726
   2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
   (1 ≤ n ≤ 1,000) 이며 10007로 나눈 나머지를 출력하시오.
 */
import java.util.Scanner;

class BOJ_11726 {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        System.out.println(tileCalc(number));
    }

    static int tileCalc(int number) {
        int[] array = new int[number];
        array[0] = 1;
        if(array.length != 1) array[1] = 2;

        for (int i = 2; i < number; i++) array[i] = (array[i - 1] + array[i - 2]) % 10007;

        return array[number - 1];
    }
}