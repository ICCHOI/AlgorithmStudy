// 이상한 문자 만들기 https://programmers.co.kr/learn/courses/30/lessons/12930
// 입력받은 문자열을 짝수는 대문자, 홀수는 소문자로 바꾸시오.
// 단, 문자열의 인덱스 기준은 전체 입력 문자열이 아닌 공백으로 나뉜 단어들을 기준으로 함.

class LowerToUpper {
    public String solution(String s) {

        byte[] bytes = new byte[s.length()];

        boolean check = true;

        for(int i=0; i<s.length(); i++){
            bytes[i]=(byte)s.charAt(i);
            if(bytes[i]<91 && bytes[i]!=32) {
                bytes[i] = (byte) (bytes[i] + 32);
            }
        }

        for(int i = 0; i<bytes.length; i++){
            if( (bytes[i]!=32) && check == true){
                bytes[i] = (byte) (bytes[i] - 32);
                check = false;
            }
            else if(check == false){
                check = true;
            }
        }

        String answer = new String(bytes);
        return answer;
    }
}

class Main3 {
    public static void main(String[] args) {
        LowerToUpper solve = new LowerToUpper();
        String str ="try hello world";
        System.out.println(solve.solution(str));
    }
}
