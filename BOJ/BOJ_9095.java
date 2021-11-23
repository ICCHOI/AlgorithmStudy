/* 1, 2, 3 더하기 https://www.acmicpc.net/problem/9095
   정수 n을 1, 2, 3의 합으로 나타내는 경우의 수를 출력하시오.
 */
import java.util.Scanner;

class BOJ_9095 {
    static void doSum (int number) {
        int[] array = new int[number];
        array[0] = 1;
        if(number > 1) array[1] = 2;
        if(number > 2) array[2] = 4;
        for (int i = 3; i < number; i++){
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        System.out.println(array[number - 1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            doSum(scanner.nextInt());
        }
    }
}
