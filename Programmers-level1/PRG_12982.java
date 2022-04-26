/* 예산 https://programmers.co.kr/learn/courses/30/lessons/12982
   부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
 */
class PRG_12982 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;

        for (int i = 1; i <= n; i++) {
            if(si < stations.length && stations[si] - w <= i) {
                si += 1;
                i = stations[si] + w + 1;
            } else {
                answer += 1;
                i += 2 * w + 1;
            }
        }
        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(new PRG_37126().solution(11, new int[]{4, 11}, 1));
//        System.out.println(new PRG_37126().solution(16, new int[]{9}, 2));
//    }
//}
