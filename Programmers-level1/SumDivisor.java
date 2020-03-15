// 약수의 합 https://programmers.co.kr/learn/courses/30/lessons/12928
// 정수 n을 입력받아 n의 약수를 모두 더한 값을 반환하시오.

import java.util.ArrayList;

class SumDivisor {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> sumList = new ArrayList();
        for(int i = 1; i<=n; i++){
            if( (n%i) == 0 ) sumList.add(i);
        }

        for(int i : sumList) answer = answer + i;

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        SumDivisor divisor = new SumDivisor();
//        System.out.println(divisor.solution(12));
//
//    }
//}