import java.util.HashMap;

class NumStringAlpha {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>() {{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.substring(i - count, i))) {
                sb.append(map.get(s.substring(i - count, i)));
                count = 0;
            }
            else if (map.containsKey(s.substring(i - count))) {
                sb.append(map.get(s.substring(i - count)));
                break;
            }

            if ( s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
            else count++;
        }
        return Integer.parseInt(sb.toString());
    }
}