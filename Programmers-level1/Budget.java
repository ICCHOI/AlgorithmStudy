/* 예산 https://programmers.co.kr/learn/courses/30/lessons/12982
   부서 별 신청 금액이 담긴 배열 d와 예산의 값 budget이 주어졌을 때,
   최대한 많은 부서에 물품을 지원 해 줄 수 있는 답을 반환하시오.
 */
import java.util.Arrays;
class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i<d.length; i++){
            if(d[i]<=budget) {
                answer ++;
                budget = budget - d[i];
            }
            else break;
        }

        return answer;
    }
}

