import java.io.*;
import java.util.*;

class DoublyPQueue {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int number = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < number; i++) {
            int calc = Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Integer> priorityQueueASC = new PriorityQueue<>();   // 123
            PriorityQueue<Integer> priorityQueueDSC = new PriorityQueue<>(Collections.reverseOrder());  // 321
            map = new HashMap<>();

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

                    if (map.size() == 0) continue;
                    if (check == 1) deleteMap(priorityQueueDSC);
                    else deleteMap(priorityQueueASC);
                }
            }
            if (map.size() == 0) stringBuilder.append("EMPTY\n");
            else {
                int input = deleteMap(priorityQueueDSC);
                stringBuilder.append(input).append(' ');
                if(map.size() > 0) input = deleteMap(priorityQueueASC);
                stringBuilder.append(input).append('\n');
            }
        }
        System.out.println(stringBuilder);
    }

    static int deleteMap (PriorityQueue<Integer> queue) {
        int toDelete;

        while(true) {
            toDelete = queue.poll();

            int count = map.getOrDefault(toDelete, 0);
            if(count ==0) continue;
            if(count ==1) map.remove(toDelete);
            else map.put(toDelete, count - 1);
            break;
        }
        return toDelete;
    }
}