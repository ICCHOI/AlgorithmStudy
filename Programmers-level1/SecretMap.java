import java.util.Arrays;
/* 비밀지도 https://programmers.co.kr/learn/courses/30/lessons/17681
   한 변의 길이 n과, 지도를 나타낸 배열 arr1, arr2가 주어졌을 때
   벽(1, #)과 공백(0, " ")을 나타내 문재열 배열로 반환하시오.
 */
class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i<n; i++){
            answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]).replaceAll("1","#").replaceAll("0"," ");
            if(answer[i].length() < n) {
                for(int j = answer[i].length(); j<n; j++){
                    answer[i] = " " + answer[i];
                }
            }
        }

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        SecretMap map = new SecretMap();
//        System.out.println(Arrays.toString(map.solution(5, new int[]{9, 20, 28, 18, 11},new int[]{30, 1, 21, 17, 28})));
//    }
//}
