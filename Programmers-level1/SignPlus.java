/*  음양 더하기 https://programmers.co.kr/learn/courses/30/lessons/76501
    절대값 정수가 담긴 배열 absolutes, 이 정수들의 부호가 담긴 boolean 배열 signs를 입력으로 받아
    배열의 정수들의 합을 반환하시오.
 */
class SignPlus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i<absolutes.length; i++){
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer += -absolutes[i];
            }
        }
        return answer;
    }
}

