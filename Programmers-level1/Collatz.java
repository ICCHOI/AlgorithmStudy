/* 콜라츠 추측 https://programmers.co.kr/learn/courses/30/lessons/12943
   콜라츠의 추측에 따라 이 작업을 몇 번 반복해야하는지를 반환하는 함수를 작성하시오.
*/
class Collatz {
    public int solution(int num) {
        double answer = 0;
        double number = num;

        while (number != 1) {
            if (answer >= 500) {
                answer = -1;
                break;
            }
            if (number % 2 == 0) {
                number = number / 2;
                answer = answer + 1;
            } else {
                number = 3 * number + 1;
                answer = answer + 1;
            }
        }

        return (int) answer;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Collatz theory = new Collatz();
//        System.out.println(theory.solution(626331));
//    }
//}