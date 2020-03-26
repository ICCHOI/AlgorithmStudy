/* 자연수 뒤집어 배열로 만들기 https://programmers.co.kr/learn/courses/30/lessons/12932
   입력ㅂ다은 자연수를 뒤집어 각 자릿수를 index로 가지는 배열로 반환하시오.
*/
import java.util.Arrays;

class ReverseArray {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];

        for(int i = 0; i<answer.length; i++){
            answer[i] = (int) (n%10);
            n = n / 10;
        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        ReverseArray array = new ReverseArray();
//        System.out.println(Arrays.toString(array.solution(12345)));
//    }
//}
