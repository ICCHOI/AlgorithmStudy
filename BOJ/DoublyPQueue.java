import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class DoublyPQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < number; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int calc = Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Integer> priorityQueueASC = new PriorityQueue<>();   // 123
            PriorityQueue<Integer> priorityQueueDSC = new PriorityQueue<>(Collections.reverseOrder());  // 321

            for (int j = 0; j < calc; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String letter = stringTokenizer.nextToken();
                if (letter.equals("I")) {
                    int input = Integer.parseInt(stringTokenizer.nextToken());
                    priorityQueueASC.add(input);
                    priorityQueueDSC.add(input);
                } else if (letter.equals("D")) {
                    int check = Integer.parseInt(stringTokenizer.nextToken());
                    if (check == 1 && !priorityQueueDSC.isEmpty()) {
                        int toDelete = priorityQueueDSC.poll();
                        priorityQueueASC.remove(toDelete);
                    } else if (check == -1 && !priorityQueueASC.isEmpty()) {
                        int toDelete = priorityQueueASC.poll();
                        priorityQueueDSC.remove(toDelete);
                    }
                }
            }
            if (priorityQueueASC.isEmpty()) stringBuilder.append("EMPTY").append('\n');
            else stringBuilder.append(priorityQueueDSC.poll()).append(' ').append(priorityQueueASC.poll()).append('\n');
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
}