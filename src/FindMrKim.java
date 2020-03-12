// 서울에서 김서방 찾기 https://programmers.co.kr/learn/courses/30/lessons/12919
// 문자열 배열 seoul의 "Kim" 문자열 값의 위치를 찾으시오.

class FindMrKim {
    public String solution(String[] seoul) {
        int where = 0;

        for(int i = 0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")) break;
            where++;
        }

        return "김서방은 " + where + "에 있다";
    }
}

class Main12{
    public static void main(String[] args) {
        FindMrKim kim = new FindMrKim();
        String[] seoul = {"Jane", "Choi", "Kim", "Park"};

        System.out.println(kim.solution(seoul));
    }
}