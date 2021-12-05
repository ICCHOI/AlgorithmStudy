/* 미로 탐색 https://www.acmicpc.net/problem/2178
   미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
   (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오
 */

import java.util.*;

class BOJ_2178 {
    static int dfs(int[][] maze, int[][] distance) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] check = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.add(new int[]{0, 0});
        distance[0][0]++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] ints : check) {
                int col = ints[0] + cur[0];
                int row = ints[1] + cur[1];

                if (col < 0 || row < 0 || col >= maze.length || row >= maze[0].length) continue;

                if (maze[col][row] == 1 && distance[col][row] == -1) {
                    queue.add(new int[]{col, row});
                    distance[col][row] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }
        return distance[maze.length - 1][maze[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        int[][] maze = new int[col][row];
        int[][] distance = new int[col][row];

        for (int i = 0; i < col; i++) {
            String rowStr = scanner.next();
            for (int j = 0; j < row; j++) {
                maze[i][j] = rowStr.charAt(j) - '0';
                distance[i][j] = -1;
            }
        }
        System.out.println(dfs(maze, distance) + 1);
    }
}
