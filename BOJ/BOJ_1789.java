/* 수들의 합 https://www.acmicpc.net/problem/1789
   서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까? S(1 ≤ S ≤ 4,294,967,295)
 */

import java.util.Scanner;

class BOJ_1789 {
    static int maxNum(long number) {
        long sum = 0L;
        int count = 0;
        for (long i = 1L; sum < number; i++) {
            sum += i;
            count++;
        }
        if (sum == number) return count;
        return count - 1;
    }

    public static void main(String[] args) {
        long target = new Scanner(System.in).nextLong();
        System.out.println(maxNum(target));
    }
}
