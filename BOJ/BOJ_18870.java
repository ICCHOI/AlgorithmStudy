/* 좌표 압축 https://www.acmicpc.net/problem/18870
   N개의 좌표를 압축해 좌표 압축된 결과를 출력하시오. 특정 수를 좌표 압축한 결과는 전체에서 그 수보다 작은 수의 개수와 같다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int[] inputArray = new int[number];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < number; i++) {
            inputArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] copyArray = Arrays.stream(inputArray).distinct().sorted().toArray();

        for (int i = 0; i < copyArray.length; i++) {
            hashMap.put(copyArray[i], i);
        }

        for (int i = 0; i < number; i++) {
            stringBuilder.append(hashMap.get(inputArray[i])).append(' ');
        }

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        System.out.println(stringBuilder);
    }
}