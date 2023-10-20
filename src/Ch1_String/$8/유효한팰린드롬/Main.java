//설명
//앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
//문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
//알파벳 이외의 문자들의 무시합니다.
//
//입력
//첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
//
//출력
//첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.

// 딱 30분.. 풀긴했는데 접근하기 어려웟다. 다시보니까 replace 쓸 필요가 없엇네
package Ch1_String.$8.유효한팰린드롬;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "NO";

        String str2 = "";

        for(char x : str.toCharArray()){
            if(Character.isAlphabetic(x)){
                str2 +=x;
            }
        }
        StringBuilder builder = new StringBuilder(str2);
        String reserve = builder.reverse().toString();
        if(str2.equals(reserve)){
            answer = "YES";
        }


        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().toUpperCase();
        System.out.println(T.solution(str));

    }
}


//풀이방법
// 입력된 문자열을 알파벳만 따로 뺀 후 StringBuilder을 이용하는 방식은 나와같았지만
// 입력된 문자열을 알파벳 따로 빼는 방식이 달랐다. replaceAll과 정규식을 활용하여 값을 구했다.
class Solution {
    public String solution(String str){
        String answer = "NO";

        // A~Z까지의 문자가 아니면 없애기
        String tmp = str.replaceAll("[^A-Z]","");

        StringBuilder stringBuilder = new StringBuilder();
        String tmpReverse = stringBuilder.append(tmp).reverse().toString();
        // 기존 값이랑 리버스값이랑 같다면 YES
        if(tmp.equals(tmpReverse)){
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().toUpperCase();
        System.out.println(T.solution(str));
    }
}
