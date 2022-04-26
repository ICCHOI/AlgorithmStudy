/* 숫자 게임 https://programmers.co.kr/learn/courses/30/lessons/12987
   A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열 A와 i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는
   배열 B가 주어질 때, B 팀원들이 얻을 수 있는 최대 승점을 return 하도록 solution 함수를 완성해주세요.
 */
import java.util.Arrays;

class PRG_12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int index = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[index]) {
                index--;
                answer++;
            }
        }
        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(new PRG_37136().solution(
//                new int[]{5,1,3,7},new int[]{2,2,6,8}));
//        System.out.println(new PRG_37136().solution(
//                new int[]{2,2,2,2},new int[]{1,1,1,1}));
//    }
//}