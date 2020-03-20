/* 모의고사 https://programmers.co.kr/learn/courses/30/lessons/42840
   1번, 2번, 3번 케이스의 패턴과 배열 answer를 비교하여 index가 같은 개수가 가장 많은
   케이스를 배열에 담아 반환하시오.
*/

import java.util.Arrays;

class Test {
    public int[] solution(int[] answers) {
        int[] result = {type1(answers), type2(answers), type3(answers)};

        if (result[0] == result[1] && result[0] == result[2]) return new int[]{1, 2, 3};

        if (result[0] > result[1] && result[0] > result[2]) return new int[]{1};
        if (result[1] > result[0] && result[1] > result[2]) return new int[]{2};
        if (result[2] > result[0] && result[2] > result[1]) return new int[]{3};
        if (result[0] == result[1] && result[0] > result[2]) return new int[]{1, 2};
        if (result[0] == result[2] && result[0] > result[1]) return new int[]{1, 3};
        if (result[1] == result[2] && result[1] > result[0]) return new int[]{2, 3};

        return result;
    }

    public int type1(int[] answers) {
        int collect = 0;
        for(int i = 0; i<answers.length; i++){
            switch(i%5) {
                case 0 : if(answers[i] == 1) collect++; break;
                case 1 : if(answers[i] == 2) collect++; break;
                case 2 : if(answers[i] == 3) collect++; break;
                case 3 : if(answers[i] == 4) collect++; break;
                case 4 : if(answers[i] == 5) collect++; break;
            }
        }
        return collect;
    }

    public int type2(int[] answers) {
        int collect = 0;
        for(int i = 0; i<answers.length; i++){
            switch(i%8) {
                case 0:
                case 2:
                case 4:
                case 6:
                    if(answers[i] == 2) collect++; break;
                case 1:
                    if(answers[i] == 1) collect++; break;
                case 3:
                    if(answers[i] == 3) collect++; break;
                case 5:
                    if(answers[i] == 4) collect++; break;
                case 7:
                    if(answers[i] == 5) collect++; break;
            }
        }
        return collect;
    }

    public int type3(int[] answers){
        int collect = 0;
        for(int i = 0; i<answers.length; i++){
            switch (i%10){
                case 0:
                case 1:
                    if(answers[i]==3) collect++; break;
                case 2:
                case 3:
                    if(answers[i]==1) collect++; break;
                case 4:
                case 5:
                    if(answers[i]==2) collect++; break;
                case 6:
                case 7:
                    if(answers[i]==4) collect++; break;
                case 8:
                case 9:
                    if(answers[i]==5) collect++; break;
            }
        }
        return collect;
    }
}

class Main{
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 3, 2, 4, 2})));
    }
}
