//설명
//알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
//문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
//단 반복횟수가 1인 경우 생략합니다.
//
//입력
//첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
//
//출력
//첫 줄에 압축된 문자열을 출력한다

// 20분 30초 소요.. 이상한 방법으로 풀엇네..
package Ch1_String.$11.문자열압축;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer = "";

        char c = ' ';
        int cnt = 1;
        for(char x : str.toCharArray()){
            if(x == c){
                cnt++;

            } else {
                if(cnt != 1){
                    answer += cnt;
                    cnt = 1;
                }
                answer += x;
                c = x;
            }
        }
        if(cnt != 1){
            answer += cnt;
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
// int i, int cnt 와 i, i+1의 값을 파악하여 같으면 cnt를 증가시키고, 다르면 cnt 값을 answer에 넣고
// 1로 초기화 시키는 방법으로 진행했다.
class Solution {
    public String solution(String str){
        String answer = "";
        str = str+" ";
        int cnt = 1;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                cnt++;
            } else {
                answer += str.charAt(i);
                if(cnt>1){answer += cnt+"";}
                cnt = 1;
            }

        }
        System.out.println("answer = " + answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(T.solution(str));
    }
}

