/* 튜플 https://programmers.co.kr/learn/courses/30/lessons/64065
   원소의 개수가 n개이고, 원소에 정해진 순서가 있는 tuple을 n-tuple이라고 하며,
   중복되는 원소가 없는 n-tuple이 문자열로 주어질 때 tuple이 표현하는 문자열을 배열에 담아 반환하시오.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> tuples = new ArrayList<>();
        int length = 0;
        StringTokenizer divided = new StringTokenizer(s, "{},");

        while (divided.hasMoreTokens()) {
                length++;
                tuples.add(Integer.parseInt(divided.nextToken()));
            }

        int[] count = new int[100001];

        for(int i = 0; i<tuples.size(); i++){
            count[tuples.get(i)]++;
        }

        int[] answer = new int[equation(length)];

        for(int i = 0; i<answer.length; i++){

            for(int j = 0; j<count.length; j++) if(count[j] == answer.length-i) answer[i] = j;

        }

        return answer;
    }
    public static int equation(int length){
        return (int) ((-1 +  Math.sqrt(1+(8*length))) / 2.0);
    }

}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
//    }
//}