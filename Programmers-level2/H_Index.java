/* H-Index https://programmers.co.kr/learn/courses/30/lessons/42747
   어떤 n개 이상의 논문을 발표한 교수의 각 논문 당 인용된 룃 수가 n개 이상이고
   나머지 논문들이 인용된 횟수가 n 미만이면 이 교수의 H-index는 n입니다.
   교수가 낸 논몬들의 인용 횟수가 담긴 배열 citations가 주어질 때 h-index 값을 반환하시오.
 */
import java.util.Arrays;

class H_Index {
    public int solution(int[] citations) {
        int answer = citations.length;

        Arrays.sort(citations);

        for (int citation : citations) {
            if (citation < answer) answer--;
            else break;
        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        H_Index index = new H_Index();
//        System.out.println(index.solution(new int[]{3, 0, 6, 1, 5}));
//    }
//}
