/* 최솟값 만들기 https://programmers.co.kr/learn/courses/30/lessons/12941
   입력으로 받은 정수형 두 배열 A와 B에서 각각의 index를 하나 씩 뽑아 두 수를 곱한 후,
   이 값을 배열의 길이 만큼 반복한 후 누적시켜 반환하시오. ( 단 같은 index를 여러번 참조 할 수 없음).
 */

import java.util.Arrays;

class Minimum {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Minimum solve = new Minimum();
        System.out.println(solve.solution(new int[]{1, 2, 8}, new int[]{7, 6, 5}));
    }
}