/* 같은 숫자는 싫어 https://programmers.co.kr/learn/courses/30/lessons/12906
   배열 arr의 연속되서 나타나는 같은 수는 하나만 남기고 제거합니다.
   단, 제거된 후 남은 수들을 반활 할때는 배열 arr의 원소의 순서를 유지해야 합니다.
*/
import java.util.*;

class HateSameNum {
    public int[] solution(int []arr) {
        int check = 0;

        for(int i = 0; i<arr.length; i++){
            if (i == arr.length-1) break;
            else if(arr[i] == arr[i+1]) check++;
        }

        int[] answer = new int[arr.length-check];
        int temp = arr[0];
        check = 0;

        for(int i = 0; i<arr.length; i++){
            if(i == arr.length-1 && arr[arr.length-1] == temp) {
                answer[check] = temp;
                break;
            }
            else if(i == arr.length-1 && arr[arr.length-1] != temp){
                answer[check] = arr[arr.length-1];
                break;
            }
            else if(arr[i+1] != temp)  {
                answer[check] = temp;
                temp = arr[i+1];
                check++;
            }
        }
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        HateSameNum remove = new HateSameNum();
//        int arr[] = {4,4,4,3,3};
//        System.out.println(Arrays.toString(remove.solution(arr)));
//    }
//}
