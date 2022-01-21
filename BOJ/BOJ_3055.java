/* 탈출 https://www.acmicpc.net/problem/3055
   R행 C열로 이루어져 있는 지도의 비어있는 곳은 '.', 물이 차있는 지역은 '*', 돌은 'X, 비버의 굴은 'D', 고슴도치의 위치는 'S'라고 할 떄,
   물은 매 분마다 상하좌우로 비어 있는 칸으로 확장되며, 고슴도치도 상하좌우로 이동할 수 있다. 고슴도치는 물이 차있는 곳으로 이동할 수 없고,
   물은 비버의 굴로 이동할 수 없다. 물과 고슴도치는 돌을 통과할 수 없다고 할 때, 고슴도치가 비버의 굴로 이동하는 최소 시간을 구하시오.
   첫째 줄에 (1 <= R, C <= 50)이 주어지고, 다음 R개 줄에는 티떱숲의 지도가 주어지며, 'D'와 'S'는 하나씩 주어진다.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BOJ_3055 {
    static void bfsWater(String[] map, int[][] time, Queue<int[]> queue) {
        int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] way : move) {
                int row = cur[0] + way[0];
                int col = cur[1] + way[1];

                if (row < 0 || col < 0 || row >= time.length || col >= time[0].length)
                    continue;

                if (time[row][col] == 0 && map[row].charAt(col) == '.') {
                    time[row][col] = time[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }

    static int bfsEscape(int[][] time, int[][] escapeTime, Queue<int[]> queue) {
        int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] way : move) {
                int row = cur[0] + way[0];
                int col = cur[1] + way[1];
                int inputTime = escapeTime[cur[0]][cur[1]] + 1;

                if (row < 0 || col < 0 || row >= time.length || col >= time[0].length)
                    continue;

                if (time[row][col] == -2) {
                    return (inputTime);
                }

                if (escapeTime[row][col] == 0 && (inputTime < time[row][col] || 0 == time[row][col])) {
                    escapeTime[row][col] = inputTime;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return (0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        String[] map = new String[row];
        int[][] time = new int[row][col];
        int[][] escapeTime = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> escapeQueue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            map[i] = scanner.nextLine();
            for (int j = 0; j < col; j++) {
                time[i][j] = 0;
                escapeTime[i][j] = 0;
                if (map[i].charAt(j) == 'X') time[i][j] = -1;
                if (map[i].charAt(j) == '*') queue.add(new int[]{i, j});
                if (map[i].charAt(j) == 'S') escapeQueue.add(new int[]{i, j});
                if (map[i].charAt(j) == 'D') time[i][j] = -2;
            }
        }
        bfsWater(map, time, queue);
        int result = bfsEscape(time, escapeTime, escapeQueue);
        if (result == 0) System.out.println("KAKTUS");
        else System.out.println(result);
    }
}
