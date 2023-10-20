//설명
//소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
//중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
//
//입력
//첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
//
//출력
//첫 줄에 중복문자가 제거된 문자열을 출력합니다.

package Ch1_String.$6.중복문자제거;

import java.util.Scanner;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public String solution(String str){
        String answer = "";

        Set<Character> set = new LinkedHashSet<>();

        for(char x : str.toCharArray()){
            set.add(x);
        }
        for(char x : set){
            answer += x;
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


// 문제풀이 (String 메서드의 charAt() 과 indexOf를 활용하였다.)
//
class Solution {
    public String solution(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            // 1. 현재 i번째 문자가 무엇인지
            // str.charAt(i);

            // 2. 현재 몇번째인지
            // i

            // 3. i번째 문자가 발견되는 index는 몇번인지
            // str.indexOf(str.charAt(i));

            // 2번과 3번이 일치하지 않으면 현재 i 번째는 중복문자라는 것이다.
            System.out.println(str.indexOf(str.charAt(i)));

            if(i == str.indexOf(str.charAt(i))){
                answer += str.charAt(i);
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