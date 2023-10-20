//설명
//한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
//문자열의 길이는 100을 넘지 않는다.
//
//출력
//첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

package Ch1_String.$10.가장짧은문자거리;

import java.util.Scanner;

public class Main {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];

        int cnt = 100;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                answer[i] = 0;
                cnt = 1;
            } else {
                answer[i] = cnt;
                cnt++;
            }
        }
        cnt = 100;

        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c){
                cnt = 1;
            } else {
                if(answer[i] > cnt){
                    answer[i] = cnt;
                }
                cnt++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String c_ = s.next();
        char c = c_.charAt(0);

        for(int x : T.solution(str,c)){
            System.out.print(x+" ");
        }
    }
}

//문제풀이
// 거리를 나타낼 임의의 p값을 만들어내고
// 왼쪽에서부터 왼쪽의 e와 떨어진 거리를 구한 다음 다시 오른쪽에서부터 돌면서
// 오른쪽e와 떨어진 거리가 더 가까울경우(= 값이 더 작을경우) 값을 변경해 주는 방식으로 했다.
class Solution {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        // 거리를 나타낼 변수값
        int p = 1000;

        for(int i=0; i<str.length(); i++){
            // 만약 str문자열의 i번째 값이 c랑 같으면
            if(str.charAt(i)==c){
                // 거리가 0이므로 p를 0으로 바꾸고
                p=0;
                // answer에 값 넣기
                answer[i]= p;
            
            // str문자열의 i번째 값이 c랑 다르다면
            } else {
                // 거리를 1 증가시키고
                p++;
                // answer에 값 넣기
                answer[i]=p;
            }
        }

        p=1000;
        for(int i = str.length()-1; i >= 0; i--){
            // 만약 str문자열의 i번째 값이 c랑 같으면
            if(str.charAt(i)==c){
                // 거리가 0이므로 p를 0으로 바꾸기
                p=0;

            // str문자열의 i번째 값이 c랑 다르다면
            } else {
                // 거리를 1 감소시키고
                p++;
                // 기존보다 p값이 작으면 answer에 값 넣기
                if(answer[i]>p){
                    answer[i]=p;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char c = s.next().charAt(0);
        for(int i : T.solution(str, c)){
            System.out.print(i+" ");
        }
    }
}