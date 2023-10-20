//설명
//앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
//문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//단 회문을 검사할 때 대소문자를 구분하지 않습니다.
//
//입력
//첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
//
//출력
//첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

package Ch1_String.$7.회문문자열;

import java.util.Scanner;

//8분소요 . 쉽다.
public class Main {
    public String solution(String str){
        String answer = "NO";

        StringBuilder stringBuilder = new StringBuilder();
        String reverseStr = stringBuilder.append(str).reverse().toString();

        if(str.equals(reverseStr)){
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String str = s.next().toUpperCase();
        System.out.println(T.solution(str));
    }
}

//문제풀이
//1. 나랑 같은 StringBuilder 사용
//2. for문으로 앞뒤비교하는 방식