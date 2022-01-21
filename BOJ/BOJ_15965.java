import java.util.Scanner;

class BOJ_15965 {
    static boolean checkPrime (int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                continue;
            }
        }

        return true;
    }

    static int findNthPrime (int number) {
        int cnt = 0;
        int prime = 1;
        while (cnt != number) {
            prime++;
            if(checkPrime(prime)) cnt++;
        }
        return prime;
    }

    public static void main(String[] args) {
        System.out.println(findNthPrime(new Scanner(System.in).nextInt()));
    }
}
