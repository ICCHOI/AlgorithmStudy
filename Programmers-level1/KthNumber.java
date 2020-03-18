/* K번째수 https://programmers.co.kr/learn/courses/30/lessons/42748
   배열 array와 [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
   array의 i부터 j까지 자른 배열을 오름차순 정렬 한 후, k번째 수를 결과로 배열에 담아 반환하시오.
*/
import java.util.Arrays;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i<answer.length; i++){
            int[]slice = new int[1+commands[i][1]-commands[i][0]];

            for(int j = 0; j<slice.length; j++){
                slice[j] = array[commands[i][0]-1+j];
            }
            Arrays.sort(slice);
            answer[i] = slice[commands[i][2]-1];
        }


        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        KthNumber number = new KthNumber();
//        int[] array = {1,5,2,6,3,7,4};
//        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
//        System.out.println(Arrays.toString(number.solution(array,commands)));
//    }
//}
