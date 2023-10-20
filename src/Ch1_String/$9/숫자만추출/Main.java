//설명
//문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
//만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
//추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
//
//입력
//첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
//
//출력
//첫 줄에 자연수를 출력합니다.

package Ch1_String.$9.숫자만추출;

import java.util.Scanner;

public class Main {
    public int solution(String str){
        int answer = 0;

        String answer2 = "";
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                answer2 += x;
            }
        }
        answer = Integer.parseInt(answer2);

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().toUpperCase();
        System.out.println(T.solution(str));
    }
}

//문제풀이
// 1. 문자 '0'은 아스키번호 == 48이다. 문자 '9'== 57 -- 아스키 번호도 특정 숫자, 소문자, 대문자는 외워두자!
//    answer을 0으로 초기화 후 str가 숫자일 경우에만 answer = answer*10 + (str.charAt(i)-48) 로 더해간다
class Solution {
    public int solution(String str){
        int answer = 0;

        for(char c : str.toCharArray()){
            if(c>=48 && c<=57){
                answer = ((answer*10)+(c-48));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(T.solution(str));
    }
}

// 2. Character 클래스 메서드에 숫자인지 아닌지 판별해주는 isDigit 메서드가 존재한다.