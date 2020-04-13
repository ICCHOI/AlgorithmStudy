/* 피보나치 수 https://programmers.co.kr/learn/courses/30/lessons/12945
   1이상 100,000이하의 n이 입력 값으로 주어질 때 n번째 피보나치 수를 1234567로 나눈 값을 반환하시오.
 */
public class Fibonacci {
    public int solution(int n) {
        return (int) (fibonacci(n));
    }

    public double fibonacci(int n) {
        double[] fiboArray = new double[n];

        fiboArray[0] = 0;
        fiboArray[1] = 1;

        for(int i = 2; i<n; i++){
            fiboArray[i] = ((fiboArray[i-1])+(fiboArray[i-2]))%(1234567);
        }
        return (fiboArray[n-1]+fiboArray[n-2])%(1234567);
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(new Fibonacci().solution(10000));
//    }
//}