/* 나누어 떨어지는 숫자 배열 https://programmers.co.kr/learn/courses/30/lessons/12910
   입력받은 arr의 index들 중 divisor로 나누어 떨어지는 요소들을 모아,
   오름차순 정렬 된 Array로 반환하시오. 단, 해당되는 수가 없으면 [-1]을 반환
*/
import java.util.ArrayList;
import java.util.Collections;

class DivisorAble {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> divisors = new ArrayList<>();

        for(int i = 0; i<arr.length; i++) if( ((arr[i]) % divisor) == 0 ) divisors.add(arr[i]);

        if((divisors.size()) != 0) {
            answer = new int[divisors.size()];
            Collections.sort(divisors);
            for (int i = 0; i < answer.length; i++) answer[i] = divisors.get(i);
        }
        else answer = new int[]{-1};

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        DivisorAble divsor = new DivisorAble();
//        int[] arr = {3, 2, 6};
//        int divisor = 10;
//
//        System.out.println(Arrays.toString(divsor.solution(arr,divisor)));
//    }
//}