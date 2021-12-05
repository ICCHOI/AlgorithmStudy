/* 토마토 https://www.acmicpc.net/problem/7576
   토마토가 모두 익을 때 까지의 최소 날짜를 구하시오.
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BOJ_7576 {
    static int dfs(int[][] box, int[][] days, Queue<int[]> queue) {
        int[][] check = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int max = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] array : check) {
                int col = cur[0] + array[0];
                int row = cur[1] + array[1];

                if (row < 0 || col < 0 || row >= box[0].length || col >= box.length) continue;
                if (days[col][row] == -1 && box[col][row] == 0) {
                    queue.add(new int[]{col, row});
                    days[col][row] = days[cur[0]][cur[1]] + 1;
                    max = Math.max(max, days[col][row]);
                }
            }
        }

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (days[i][j] == -1 && box[i][j] == 0) {
                    max = -1;
                    break;
                }
            }
        }

        return (max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] box = new int[col][row];
        int[][] days = new int[col][row];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                box[i][j] = scanner.nextInt();
                days[i][j] = -1;
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    days[i][j]++;
                }
            }
        }
        System.out.println(dfs(box, days, queue));
    }
}
