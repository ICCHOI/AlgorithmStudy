public class TakeMiddleLetters {
    public String solution(String s) {
        String answer;

        if((s.length()%2)==1){
            answer = s.substring((s.length()-1)/2,((s.length()-1)/2)+1);
        }
        else{
            answer = s.substring(((s.length()-1)/2),((s.length()-1)/2)+2);
        }
        return answer;
    }
}

class Main7{
    public static void main(String[] args) {
        TakeMiddleLetters letters = new TakeMiddleLetters();
        System.out.println(letters.solution("qwer"));
    }
}