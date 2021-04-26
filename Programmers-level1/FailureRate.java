/* 실패율 https://programmers.co.kr/learn/courses/30/lessons/42889
   (스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수)를 실패율이라 하고
    스테이지 개수 N과 유저가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages를 입력으로 받아,
    실패율이 높은 스테이지의 번호부터 내림차순으로 담겨있는 배열을 반환하시오.
 */
import java.util.Arrays;

class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);

        int[] desc = new int[stages.length];

        for (int i = 0; i < desc.length; i++) {
            desc[i] = stages[stages.length - 1 - i];
        }

        int[] chall = new int[N];
        int[] fail = new int[N];

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < N; j++) {
                if (stages[i] >= j + 1) fail[j] ++;
                if (stages[i] == j + 1) chall[j] ++;
            }
        }

        double[] failureRate = new double[N];

        for(int i = 0; i<failureRate.length; i++){
            if(fail[i] == 0) failureRate[i] = 0;
            else failureRate[i] = (double)chall[i]/(double) fail[i];
        }

        double[] sort = Arrays.copyOf(failureRate, failureRate.length);

        Arrays.sort(sort);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(sort[N-1-i] == failureRate[j]) {
                    answer[i] = j+1;
                    failureRate[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        FailureRate rate = new FailureRate();
//        System.out.println(Arrays.toString(rate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
//        System.out.println(Arrays.toString(rate.solution(4, new int[]{4, 4, 4, 4, 4})));
//        System.out.println(Arrays.toString(rate.solution(3, new int[]{2, 2, 2, 2, 2})));
//    }
//}

