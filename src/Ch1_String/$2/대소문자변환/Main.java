
//설명
//대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
//문자열은 영어 알파벳으로만 구성되어 있습니다.
//
//출력
//첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.




package Ch1_String.$2.대소문자변환;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";

        for(char x : str.toCharArray()){
            if(x == Character.toUpperCase(x)){
                answer += Character.toLowerCase(x);
            } else {
                answer += Character.toUpperCase(x);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String str = s.next();

        System.out.println(T.solution(str));
    }
}

// 문제풀이 해설
// Character 클래스의 isLowerCase( ) 메서드가 소문자인지 boolean 형식으로 나타내주는 것이 있다.
// 문제풀이 방법중에는 대소문자 아스키코드로 바꾸는 방법도 있다(A=65, a=97 이므로 32차이)
