/*  키패드 누르기 https://programmers.co.kr/learn/courses/30/lessons/67256
    순서대로 누를 번호가 담긴 배열 numbers, 어느 손 잡이인지를 알아내는 문자열 hand가 변수로 주어질 때,
    각 번호를 누른 손가락이 어느쪽 손인지를 나타내는 배열을 반환하시오.
 */
class PushKeypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        char[][] pad = new char[4][3];
        int l = 1;

        for (int i = 0; i < pad.length - 1; i++) {
            for (int j = 0; j < pad[0].length; j++) {
                pad[i][j] = Character.forDigit(l, 10);
                l++;
            }
        }

        pad[3][0] = '*';
        pad[3][1] = '0';
        pad[3][2] = '#';

        char left = '*';
        char right = '#';

        int[] compare = new int[6];

        for (int number : numbers) {

            switch (number) {
                case 1:
                case 4:
                case 7:
                    left = Character.forDigit(number, 10);
                    answer.append('L');
                    break;

                case 2:
                case 5:
                case 8:
                case 0:
                    for (int k = 0; k < pad.length; k++) {
                        for (int j = 0; j < pad[0].length; j++) {

                            if (pad[k][j] == left) {
                                compare[0] = k;
                                compare[1] = j;
                                if (left == Character.forDigit(number, 10)) {
                                    compare[2] = k;
                                    compare[3] = j;
                                }
                            } else if (pad[k][j] == right) {
                                compare[4] = k;
                                compare[5] = j;
                                if (right == Character.forDigit(number, 10)) {
                                    compare[2] = k;
                                    compare[3] = j;
                                }
                            } else if (pad[k][j] == Character.forDigit(number, 10)) {
                                compare[2] = k;
                                compare[3] = j;
                            }
                        }
                    }

                    int right_distance = Math.abs(compare[4] - compare[2]) + Math.abs(compare[5] - compare[3]);
                    int left_distance = Math.abs(compare[0] - compare[2]) + Math.abs(compare[1] - compare[3]);

                    if (left_distance < right_distance) {
                        left = Character.forDigit(number, 10);
                        answer.append('L');
                    } else if (right_distance < left_distance) {
                        right = Character.forDigit(number, 10);
                        answer.append('R');
                    } else {
                        if (hand.equals("right")) {
                            right = Character.forDigit(number, 10);
                            answer.append('R');
                        } else {
                            left = Character.forDigit(number, 10);
                            answer.append('L');
                        }
                    }
                    break;

                case 3:
                case 6:
                case 9:
                    right = Character.forDigit(number, 10);
                    answer.append('R');
                    break;
            }
        }
        return answer.toString();
    }
}

//class Main {
//    public static void main(String[] args) {
//        PushKeypad keypad = new PushKeypad();
//        System.out.println(keypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
//        System.out.println(keypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
//        System.out.println(keypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
//        System.out.println(keypad.solution(new int[]{2, 5, 8, 0, 5, 8, 2, 0, 5, 2, 8, 0, 2, 5, 0}, "right"));
//        System.out.println(Character.forDigit(0, 10));
//    }
//}