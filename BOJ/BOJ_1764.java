/* 듣보잡 https://www.acmicpc.net/problem/1764
   듣도 못한 사람이 N 줄에 걸쳐, 보도 못한 사람이 그 후 M줄에 걸쳐 나타날 때 듣도 보도 못한 사람의 수와 명단을 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int noHear = Integer.parseInt(stringTokenizer.nextToken());
        int noSee = Integer.parseInt(stringTokenizer.nextToken());
        HashSet<String> noHears = new HashSet<>();
        ArrayList<String> outputs = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < noHear; i++) {
            noHears.add(bufferedReader.readLine());
        }
        for (int i = 0; i < noSee; i++) {
            String noHearMan = bufferedReader.readLine();
            if (noHears.contains(noHearMan)) outputs.add(noHearMan);
        }

        stringBuilder.append(outputs.size()).append('\n');
        outputs.sort(String::compareTo);
        for (String str : outputs) stringBuilder.append(str).append('\n');

        System.out.print(stringBuilder);
    }
}