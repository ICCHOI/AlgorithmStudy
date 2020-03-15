// 문자열 내 p와 y의 개수 https://programmers.co.kr/learn/courses/30/lessons/12916
// 문자열 안의 대소문자의 구분이 없는 P와 Y의 개수를 세어 개수가 같거나 없으면 True, 다르면 false를 반환하시오.

class CountPandY {
    boolean solution(String s) {
        boolean answer = true;

        char[] chars = new char[s.length()];

        for(int i = 0; i<chars.length; i++) chars[i]=s.charAt(i);

        int[] count = new int[chars.length];

        for(int i = 0; i<count.length; i++){
            if(chars[i] == 'P' || chars[i] == 'p') count[i] = 1;
            else if(chars[i] == 'Y' || chars[i] == 'y') count[i] = -1;
        }

        int sum = 0;

        for(int i : count) sum = sum + i;

        if(sum != 0) answer = false;

        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        CountPandY pAndY = new CountPandY();
//        System.out.println(pAndY.solution("Pyy"));
//    }
//}
