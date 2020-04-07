/* x만큼 간격이 있는 n개의 숫자 https://programmers.co.kr/learn/courses/30/lessons/12954
   정수 x와 자연수 n을 입력 받아 x부터 시작해 공차를 x로 가지는 등차수열을 배열에 반환하시오.
 */
import java.util.Arrays;

public class ArithmeticProgression {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(long i = 0; i<n; i++) {
            answer[(int) i] = x+(x*i);
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new ArithmeticProgression().solution(-4,2)));
//    }
//}