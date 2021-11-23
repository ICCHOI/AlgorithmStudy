/* AC

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String ac = bufferedReader.readLine();
            int count = Integer.parseInt(bufferedReader.readLine());
            String array = bufferedReader.readLine();
            String[] input = array.substring(1, array.length() - 1).split(",");
            int reverse = 1;
            boolean errorCheck = false;
            for (int j = 0; j < count; j++) deque.addLast(Integer.parseInt(input[j]));
            for (int k = 0; k < ac.length(); k++) {
                if (ac.charAt(k) == 'R') reverse *= -1;
                if (ac.charAt(k) == 'D') {
                    if (reverse < 0) {
                        if (deque.isEmpty()) {
                            stringBuilder.append("error").append('\n');
                            errorCheck = true;
                            break;
                        }
                        else deque.removeLast();
                    }
                    else {
                        if (deque.isEmpty()) {
                            stringBuilder.append("error").append('\n');
                            errorCheck = true;
                            break;
                        }
                        else deque.removeFirst();
                    }
                }
            }
            if (!errorCheck) {
                stringBuilder.append('[');
                if (reverse < 0) {
                    Iterator<Integer> reverseIter = deque.descendingIterator();
                    while (reverseIter.hasNext()) stringBuilder.append(reverseIter.next()).append(',');
                    if (deque.isEmpty()) stringBuilder.append(']').append('\n');
                    else stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(']').append('\n');
                } else {
                    Iterator<Integer> iterator = deque.iterator();
                    while (iterator.hasNext()) stringBuilder.append(iterator.next()).append(',');
                    if (deque.isEmpty()) stringBuilder.append(']').append('\n');
                    else stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(']').append('\n');
                }
            }
        }
        System.out.print(stringBuilder);
    }
}