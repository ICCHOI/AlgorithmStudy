/* 두 개 뽑아서 더하기 https://programmers.co.kr/learn/courses/30/lessons/68644
    정수 배열 numbers의 서로 다른 index의 두 개의 수를 뽑아 더해서 만들 수 있는
    모든 수를 배열에 오름차순으로 담아 return 하시오.
 */
import java.util.Arrays;

class PickTwoAndAdd {
    public int[] solution(int[] numbers) {
        boolean[] count = new boolean[201];
        int size = 0;

        for(int i = 0; i<numbers.length; i++){
            for(int j = 1+i; j<numbers.length; j++){
                if(count[numbers[i]+numbers[j]] == false) {
                    count[numbers[i]+numbers[j]] = true;
                    size ++;
                }
            }
        }

        int[] answer = new int[size];
        int boolcount = 0;

        for(int i = 0; i<count.length; i++){
            if(count[i] == true) {
                answer[boolcount] = i;
                boolcount++;
            }
        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        PickTwoAndAdd pTAA = new PickTwoAndAdd();
//        System.out.println(Arrays.toString(pTAA.solution(new int[]{5,0,2,7})));
//    }
//}