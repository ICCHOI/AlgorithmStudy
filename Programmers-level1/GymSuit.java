import java.util.Arrays;

/* 체육복 https://programmers.co.kr/learn/courses/30/lessons/42862
   학생의 수 n, 학생 번호가 담긴 배열 lost, 여벌의 체육복을 가진 학생들의 번호 reverse가
   매개변수로 주어질 때, 앞과 뒤 숫자의 학생들에게만 체육복을 빌려 줄 수 있습니다.
   체육 수업을 들을 수 있는 학생의 최댓값을 반환하시오.
 */
public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int borrow = 0, check = 0;

        for (int i = 0; i < lost.length; ++i) {
            for (int j = 0; j < reserve.length; ++j) {
                if (lost[i] == reserve[j]) {
                    ++check;
                    lost[i] = 35;
                    reserve[j] = 45;
                }
            }
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; ++i) {

            for (int j = borrow; j < reserve.length; ++j) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] || lost[i] == reserve[j] + 1) {
                    ++borrow;
                    ++check;
                    break;
                }
            }
        }
        return n - lost.length + check;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(new GymSuit().solution(30, new int[]{30}, new int[]{24,25,28,29}));
    }
}