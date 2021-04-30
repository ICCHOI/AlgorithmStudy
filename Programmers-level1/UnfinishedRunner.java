/* 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576
    참가한 선수를 담은 배열 participant와 완주한 선수를 담은 문자열 배열 completion를 입력으로 받아서
    완주하지 못한 선수를 반환하시오.
 */

import java.util.Arrays;

class UnfinishedRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {

            if (i == participant.length-1) {
                answer = participant[i];
            } else if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        UnfinishedRunner runner = new UnfinishedRunner();
//        System.out.println(runner.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
//    }
//}
