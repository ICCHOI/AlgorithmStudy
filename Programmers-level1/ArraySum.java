/* 행렬의 덧셈 https://programmers.co.kr/learn/courses/30/lessons/12950
   행과 열의 크기가 같은 행렬을 입력 받아 두 행렬의 같은 행과 열의 값을 더한 결과를 반환하시오.
*/
class ArraySum {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr1[arr1.length-1].length];

        for(int i = 0; i<arr1.length; i++){

            for(int j = 0; j<arr1[arr1.length-1].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
//                System.out.println(answer[i][j]);
            }
        }
        return answer;
    }
}
