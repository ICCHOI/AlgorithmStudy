/* 계단 오르기 https://www.acmicpc.net/problem/2579
   계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
   연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
   마지막 도착 계단은 반드시 밟아야 한다. 다음의 규칙을 만족하는 최댓값을 구하시오.
 */
import java.util.Scanner;

class BOJ_2579 {
    static int getScore (int[] scores) {
        if (scores.length < 3) return 0;

        int[] sumScores = new int[scores.length];

        sumScores[0] = scores[0];
        sumScores[1] = scores[1];
        sumScores[2] = scores[2];

        for (int i = 3; i < scores.length; i++) {
            sumScores[i] = Math.min(sumScores[i - 2], sumScores[i - 3]) + scores[i];
        }

        return Math.min(sumScores[scores.length - 2], sumScores[scores.length - 3]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] scores = new int[number];
        int max = 0;
        for (int i = 0; i < number; i++) {
            scores[i] = scanner.nextInt();
            max += scores[i];
        }
        System.out.println(max - getScore(scores));
    }
}
