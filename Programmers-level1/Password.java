/* 시저 암호 https://programmers.co.kr/learn/courses/30/lessons/12926
   문자열을 입력받아 n 만큼 byte 숫자를 증가시키시오.
   단, 공백은 밀어도 공백이며, n은 1 이상 25 이하인 자연수임.
*/
class Password {
    public String solution(String s, int n) {
        byte[] encryption = new byte[s.length()];

        for(int i = 0; i<encryption.length; i++) encryption[i] = (byte)s.charAt(i);

        for(int i = 0; i<encryption.length; i++) {
            if (65 <= encryption[i] && encryption[i] <= 90) {
                encryption[i] = (byte) (encryption[i] + n);
                if (encryption[i] > 90) encryption[i] = (byte) (encryption[i] - 26);
            }

            if (97 <= encryption[i] && encryption[i] <= 122) {
                if(encryption[i]+n > 122) encryption[i] = (byte) (encryption[i] - 26);

                encryption[i] = (byte) (encryption[i] + n);
            }
        }
        return new String(encryption);
    }
}

//class Main{
//    public static void main(String[] args) {
//        Password password = new Password();
//        System.out.println(password.solution("a Z z",25));
//    }
//}
