/* 카펫 https://programmers.co.kr/learn/courses/30/lessons/42842
   중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫이 있다고 가정할 때
   갈색과 노란색의 개수를 담아 카펫의 가로 길이와 세로 길이를 배열에 담아 반환하시오. ( 단 가로는 항상 세로 보다 큼 )
 */
//import java.util.Arrays;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int[] divisors = getDivisors(brown + yellow);

        for(int i = 0; i<(divisors.length+1)/2; i++){
            if((divisors[divisors.length-1-i]+divisors[i])*2 - 4 == brown){
                answer[0] = divisors[divisors.length-1-i];
                answer[1] = divisors[i];
                break;
            }
        }

        return answer;
    }

    int[] getDivisors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] divisors = new int[count];

        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors[index] = i;
                index++;
            }
        }
        return divisors;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Solution solve = new Solution();
//        System.out.println(Arrays.toString(solve.solution(20, 16)));
//    }
//}