// 핸드폰 번호 가리기 https://programmers.co.kr/learn/courses/30/lessons/12948
// 고객의 전화번호를 문자열 입력값으로 받아 뒷자리 4자리를 제외한 나머지를 *로 바꿈

class ProtectPhoneNum {
    public String solution(String phone_number) {

        String nocut = phone_number.substring(phone_number.length()-4);

        String star ="";

        for(int i = 0; i<phone_number.length()-4; i++){
            star = star + "*";
        }

        String answer = star+nocut;
        return answer;
    }
}

class Main4{
    public static void main(String[] args) {
        ProtectPhoneNum solution2 = new ProtectPhoneNum();
        System.out.println(solution2.solution("027778888"));
    }
}