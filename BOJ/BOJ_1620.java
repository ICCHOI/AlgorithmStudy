/* 나는야 포켓몬 마스터 이다솜 https://www.acmicpc.net/problem/1620
   입력으로 숫자가 들어왔다면 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 포켓몬의 이름에 해당하는 번호를 출력
   1 <= N, M <= 100,000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int inputNumber = Integer.parseInt(stringTokenizer.nextToken());
        int findNumber = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i <= inputNumber; i++) {
            String inputString = bufferedReader.readLine();
            stringIntegerHashMap.put(inputString, i);
            integerStringHashMap.put(i, inputString);
        }

        for(int i = 0; i < findNumber; i++) {
            String toFind = bufferedReader.readLine();
            if (stringIntegerHashMap.containsKey(toFind)) {
                stringBuilder.append(stringIntegerHashMap.get(toFind)).append('\n');
            }
            else {
                int toFindInt = Integer.parseInt(toFind);
                stringBuilder.append(integerStringHashMap.get(toFindInt)).append('\n');
            }
        }
        System.out.print(stringBuilder);
    }
}