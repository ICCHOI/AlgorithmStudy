// 정수 내림차순으로 배치하기 https://programmers.co.kr/learn/courses/30/lessons/12933?language=java
// 입력받은 정수를 큰 수 부터 내림차순으로 바꾸시오.

import java.util.Arrays;

class IntegerDescend {
    public long solution(long n) {
        String s = String.valueOf(n);

        long array[] = new long[s.length()];

        for(int i=0; i<array.length; i++){
            array[i]=s.charAt(i);
        }
        Arrays.sort(array);

        char arr[] = new char[array.length];
        for(int i=0; i<array.length; i++){
            arr[i]=(char)array[array.length-1-i];
        }

        String st = "";
        for(int i=0; i<arr.length; i++){
            st = st+arr[i];
        }

        long answer = Long.parseLong(st);
        return answer;
    }
}

//class Main{
//    public static void main(String[] args) {
//        IntegerDescend solve = new IntegerDescend();
//        long n = 118372;
//        System.out.println(solve.solution(n));
//    }
//}