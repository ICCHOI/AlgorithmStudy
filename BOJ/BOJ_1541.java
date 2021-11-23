/* 잃어버린 괄호 https://www.acmicpc.net/problem/1541
   괄호를 적절히 쳐 주어진 스트링의 수식을 최솟값으로 만드시오.
 */
import java.util.Scanner;

class BOJ_1541 {
    public static void main(String[] args) {
        String inputString = new Scanner(System.in).nextLine();
        int minusIndex = -1;
        int sum = 0;
        if (inputString.contains("-")) {
            for (int i = 0; i < inputString.length(); i++) {
                if(inputString.charAt(i) == '+') minusIndex++;
                else if(inputString.charAt(i) == '-') {
                    minusIndex ++;
                    break;
                }
            }
        }
        String[] numbers = inputString.split("[+|-]");

        if (minusIndex == -1) {
            for (String num : numbers) sum += Integer.parseInt(num);
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                if (i <= minusIndex) sum += Integer.parseInt(numbers[i]);
                else sum -= Integer.parseInt(numbers[i]);
            }
        }
        System.out.println(sum);
    }
}