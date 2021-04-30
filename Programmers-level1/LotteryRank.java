/* 로또의 최고 순위와 최저 순위 https://programmers.co.kr/learn/courses/30/lessons/77484
   로또의 번호가 담긴 배열 lottos와 로또 정답 번호가 담긴 배열 win_numbs를 비교하여 lotts의 0이
   알아 볼 수 없는 수라고 가정하고 로또의 최대 등수와 최소 등수를 배열에 반환하시오.
 */
class LotteryRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        for (int lotto : lottos) {
            if (lotto == 0) {
                ++answer[0];
                continue;
            }
            for (int win_num : win_nums) {

                if (lotto == win_num) {
                    ++answer[1];
                    break;
                }

            }
        }

        answer[0] += answer[1];

        for (int i = 0; i < 2; i++) {
            if (answer[i] > 1) {
                answer[i] = 7 - answer[i];
            } else {
                answer[i] = 6;
            }
        }

        return answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        LotteryRank rank = new LotteryRank();
//        System.out.println(Arrays.toString(rank.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
//        System.out.println(Arrays.toString(rank.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38,19, 20, 40, 15, 25})));
//        System.out.println(Arrays.toString(rank.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
//    }
//}
