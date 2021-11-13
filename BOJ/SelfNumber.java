/* 셀프 넘버 https://www.acmicpc.net/problem/4673
   양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수 일 때 d(75) = 75+7+5 = 87 를 가정하면
   n을 d(n)의 생성자라고 한다. 생성자가 없는 숫자인 10000이하의 셀프 넘버를 출력하시오.
 */
class SelfNumber {
    static int selfnumber(int num){
        int result = num;

        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] selfNumbers = new boolean[10000];

        for (int i = 1; i < selfNumbers.length; i++) {
            if (selfnumber(i) <= 10000) selfNumbers[selfnumber(i) - 1] = true;
        }

        for (int i = 1; i < selfNumbers.length; i++) {
            if(!selfNumbers[i - 1]) System.out.println(i);
        }
    }
}
