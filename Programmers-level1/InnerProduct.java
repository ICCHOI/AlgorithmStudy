/* 내적 https://programmers.co.kr/learn/courses/30/lessons/70128
   두 정수 배열 a, b를 입력 값으로 받아 a와 b의 내적을 반환하시오.
 */
class InnerProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i<a.length; i++){
            answer += a[i] * b[i];
        }

        return answer;
    }
}