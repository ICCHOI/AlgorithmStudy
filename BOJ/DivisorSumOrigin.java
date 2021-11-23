import java.io.*;

class DivisorSumOrigin {
    static long checkDivisor(int num) {
        long sum = 0L;
        for (int i = 1; i <= num; i++)
            sum += (long)i * (num / i);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        long[] divisors = new long[1000000];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            divisors[i] = checkDivisor(i);
        }
        for (int i = 0; i < number; i++) {
            sb.append(divisors[Integer.parseInt(bf.readLine())]).append('\n');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
