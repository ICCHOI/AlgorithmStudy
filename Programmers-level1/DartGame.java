import java.util.Arrays;
/*  다트 게임 https://programmers.co.kr/learn/courses/30/lessons/17682
    점수|보너스|[옵션] 으로 이루어진 뭇자열 3세트를 입력으로 받아 총 점수를 반환하시오.
 */
class DartGame {
    public int solution(String dartResult) {
       int[] plus = new int[3];
        int pointer = 0;

        for (int i = 0; i < dartResult.length(); i++) {

            if (dartResult.charAt(i) == 'S') {
                plus[pointer] = (int) Math.pow(plus[pointer], 1);
                pointer++;
            } else if (dartResult.charAt(i) == 'D') {
                plus[pointer] = (int) Math.pow(plus[pointer], 2);
                pointer++;
            } else if (dartResult.charAt(i) == 'T') {
                plus[pointer] = (int) Math.pow(plus[pointer], 3);
                pointer++;
            } else if (dartResult.charAt(i) == '*') {
                plus[pointer - 1] = plus[pointer - 1] * 2;
                if (pointer != 1) plus[pointer - 2] = plus[pointer - 2] * 2;
            } else if (dartResult.charAt(i) == '#') {
                plus[pointer - 1] = plus[pointer - 1] * -1;
            } else {
                if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    plus[pointer] = 10;
                    i++;
                } else {
                    plus[pointer] = Character.getNumericValue(dartResult.charAt(i));
                }
            }
        }

        return plus[0]+plus[1]+plus[2];
    }
}

//class Main {
//    public static void main(String[] args) {
//        DartGame game = new DartGame();
//        System.out.println(game.solution("1D2S3T*"));
//    }
//}