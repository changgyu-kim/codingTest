//설명
//영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
//특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
//
//출력
//첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


package Ch1_String.$5.특정문자뒤집기;

import java.util.Scanner;

// 문제 이상함
public class Main {
    public String solution(String str){
        String answer = "";
        char[] c = str.toCharArray();
        int front = 0;
        int end = str.length()-1;

        while(front<end){
            if(!Character.isAlphabetic(c[front])){
                front++;
            } else if (!Character.isAlphabetic(c[end])){
                end--;
            } else {
                char tmp = c[front];
                c[front] = c[end];
                c[end] = tmp;
                front++;
                end--;
            }

        }
        for(char x : c){
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

// 문제풀이
class Solution {
    public String solution(String str){
        String answer="";
        char[] c = str.toCharArray();
        int front = 0;
        int end = str.length()-1;
        while(front<end){
            // 알파벳이 참인지 알려주는 메서드
            if(!Character.isAlphabetic(c[front])){
                front++;
            } else if (!Character.isAlphabetic(c[end])) {
                end--;
            } else {
                char tmp = c[front];
                c[front] = c[end];
                c[end] = tmp;
                front++;
                end--;
            }
        }
        answer = String.valueOf(c);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(T.solution(str));
    }
}