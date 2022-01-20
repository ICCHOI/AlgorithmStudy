/* 숨바꼭질 https://www.acmicpc.net/problem/1697
   수빈이의 위치 N과 동생의 위치 K가 주어질 때, 수빈이는 1초후에 x + 1, x - 1, 2 * x의 위치로 순간이동을 할 수 있다.
   수빈이가 동생을 찾으러 가는 가장 빠른 시간이 몇 초인지 구하시오.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BOJ_1697 {
    static int bfs(int[] findSister, Queue<Integer> queue, int sisterIndex) {
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int[] check = new int[]{curIndex - 1, curIndex + 1, curIndex * 2};

            for (int checkIndex : check) {
                if (checkIndex < 0 || checkIndex >= findSister.length) continue;

                if (findSister[checkIndex] == -1) {
                    queue.add(checkIndex);
                    findSister[checkIndex] = findSister[curIndex] + 1;
                    if (checkIndex == sisterIndex) return findSister[checkIndex];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myIndex = scanner.nextInt();
        int sisterIndex = scanner.nextInt();

        int length = Math.max(myIndex, sisterIndex);
        int[] findSister = new int[(length * 2) + 1];
        for (int i = 0; i < (length * 2) + 1; i++) {
            findSister[i] = -1;
        }
        findSister[myIndex]++;
        Queue<Integer> queue = new LinkedList<>();
        if (myIndex != sisterIndex) queue.add(myIndex);

        System.out.println(bfs(findSister, queue, sisterIndex));
    }
}
