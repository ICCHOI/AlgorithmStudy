/* 불! https://www.acmicpc.net/problem/4179
   상하좌우로 확산되는 불과, 지훈이의 위치, 지나갈수 있는 공간과 벽이 주어질 때, 지훈이가 탈출 할 수 있는 가장 빠른 시간 혹은 불가능을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_4179 {
    static void dfs(String[] maze, int[][] time, Queue<int[]> queue) {
        int[][] check = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] array : check) {
                int row = cur[0] + array[0];
                int col = cur[1] + array[1];

                if (row < 0 || col < 0 || row >= time.length || col >= time[0].length) continue;

                if (maze[row].charAt(col) != '#' && time[row][col] < 0) {
                    queue.add(new int[]{row, col});
                    time[row][col] = time[cur[0]][cur[1]] + 1;
                }
            }
        }
    }

    static String dfsEscape(int[][] time, int[][] escapeTime, Queue<int[]> queue) {
        int[][] check = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curTime = escapeTime[cur[0]][cur[1]];
            if (curTime == time[cur[0]][cur[1]]) continue;

            for (int[] array : check) {
                int row = cur[0] + array[0];
                int col = cur[1] + array[1];

                if (row < 0 || col < 0 || row >= time.length || col >= time[0].length) {
                    return (String.valueOf(curTime + 1));
                }

                if (escapeTime[row][col] == -1 && ((time[row][col] > curTime) || time[row][col] == -1)) {
                    queue.add(new int[]{row, col});
                    escapeTime[row][col] = curTime + 1;
                }
            }
        }
        return ("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());

        int[][] time = new int[row][col];
        int[][] escapeTime = new int[row][col];
        String[] maze = new String[row];
        Queue<int[]> queueFire = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            maze[i] = bufferedReader.readLine();
            for (int j = 0; j < col; j++) {
                time[i][j] = -1;
                escapeTime[i][j] = -1;
                if (maze[i].charAt(j) == 'F') {
                    queueFire.add(new int[]{i, j});
                    time[i][j]++;
                }
                if (maze[i].charAt(j) == 'J') {
                    queue.add(new int[]{i, j});
                    escapeTime[i][j]++;
                }
                if (maze[i].charAt(j) == '#') {
                    time[i][j]--;
                }
            }
        }

        dfs(maze, time, queueFire);
        System.out.println(dfsEscape(time, escapeTime, queue));
    }
}
