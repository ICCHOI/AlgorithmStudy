/* 제일 작은 수 제거하기 https://programmers.co.kr/learn/courses/30/lessons/12935
   int형 배열을 입력으로 받아 배열에서 가장 작은 수를 제거한 배열을 반환하시오.
 */
import java.util.Arrays;

class RemoveSmallNum {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int small = arr[0];
        int index = 0;
        boolean check = false;
        int[] answer = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (small > arr[i]) {
                small = arr[i];
                index = i;
            }
        }


        for (int i = 0; i < answer.length; i++) {

            if (i == index) check = true;

            if (check == true) answer[i] = arr[i + 1];

            else answer[i] = arr[i];

        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        RemoveSmallNum remove = new RemoveSmallNum();
//        System.out.println(Arrays.toString(remove.solution(new int[]{4,3,2,1})));
//    }
//}


