/* 행렬의 곱셈 https://programmers.co.kr/learn/courses/30/lessons/12949
   두 정수형 이차원 배열 arr1, arr2를 입력 값으로 받아 두 행렬(배열)의 곱을 반환하시오.
 */
class MatrixMultiple {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        MatrixMultiple mul = new MatrixMultiple();
//        System.out.println(Arrays.deepToString(mul.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
//        System.out.println(Arrays.deepToString(mul.solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));
//        System.out.println(Arrays.deepToString(mul.solution(new int[][]{{5, -10, 7}, {3, 6, 15}}, new int[][]{{7,1},{2,5},{4,3}})));
//    }
//}
