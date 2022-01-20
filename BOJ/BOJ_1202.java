/* 보석 도둑 https://www.acmicpc.net/problem/1202
   첫 줄에 보석의 개수 N과 가방의 개수 K, 다음 N개의 줄에는 보석의 정보 무게 M과 가격 V가 주어질 때,
   각 가방에 담을 수 있는 최대 무게는 C이며 그 다음 K개 줄에 주어진다. 가방에는 보석을 하나만 담을 수 있다.
   훔칠 수 있는 보석의 최대 가격을 구하시오.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_1202 {
    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());
        Jewels[] jewels = new Jewels[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] bags = new int[K];
        long maxValue = 0L;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = stoi(st.nextToken());
            int value = stoi(st.nextToken());
            jewels[i] = new Jewels(weight, value);
        }

        Arrays.sort(jewels, (o1, o2) -> {
            int i = Integer.compare(o1.weight, o2.weight);

            if (i == 0) {
                return Integer.compare(o1.value, o2.value);
            }
            return i;
        });

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = stoi(st.nextToken());
        }
        Arrays.sort(bags);

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewels[j].getWeight() <= bags[i]) pq.offer(jewels[j++].getValue());
            if (!pq.isEmpty()) maxValue += pq.poll();
        }
        System.out.println(maxValue);
    }
}

class Jewels {
    int weight;
    int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Jewels(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
