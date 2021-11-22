/* 이중 우선순위 큐

*/
import java.io.*;
import java.util.*;

class DoublyPQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int number = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < number; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int calc = Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Integer> priorityQueueASC = new PriorityQueue<>();
            PriorityQueue<Integer> priorityQueueDSC = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < calc; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String letter = stringTokenizer.nextToken();

                if (letter.equals("I")) {
                    int input = Integer.parseInt(stringTokenizer.nextToken());
                    priorityQueueASC.add(input);
                    priorityQueueDSC.add(input);
                    map.put(input, map.getOrDefault(input, 0) + 1);
                } else if (letter.equals("D")) {
                    int check = Integer.parseInt(stringTokenizer.nextToken());
                    int target;

                    if (map.size() == 0) continue;

                    if (check == 1) target = findMap(priorityQueueDSC, map);
                    else target = findMap(priorityQueueASC, map);

                    if (map.getOrDefault(target, 0) == 1) map.remove(target);
                    else map.put(target, map.getOrDefault(target, 0) - 1);
                }
            }
            if (map.size() == 0) stringBuilder.append("EMPTY\n");
            else {
                int input = findMap(priorityQueueDSC, map);
                stringBuilder.append(input).append(' ');
                if(map.size() > 0) input = findMap(priorityQueueASC, map);
                stringBuilder.append(input).append('\n');
            }
        }
        System.out.println(stringBuilder);
    }

    static int findMap (PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int toDelete;

        while(true) {
            toDelete = queue.poll();
            int count = map.getOrDefault(toDelete, 0);
            if(count == 0) continue;
            break;
        }

        return toDelete;
    }
}