/* 카드2 https://www.acmicpc.net/problem/2164
   카드가 한 장 남을 때 까지 한 장을 뽑아 버리고, 그 다음 장을 뽑아 맨 뒤로 옮기기를 반복한다.
   카드는 1번부터 N까지 오름차순으로 정렬되어 있으며 N(1 ≤ N ≤ 500,000)일 때 마지막 카드를 출력하시오.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BOJ_2164 {
    public static void main(String[] args) {
        int count = new Scanner(System.in).nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int input;

        for (int i = 0; i < count; i++)
            queue.add(i + 1);
        while (queue.size() != 1) {
            queue.poll();
            if(queue.size() > 1) {
                input = queue.poll();
                queue.add(input);
            }
        }
        System.out.println(queue.poll());
    }
}
