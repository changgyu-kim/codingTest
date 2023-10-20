//설명
//1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
//2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
//
//입력
//첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
//
//출력
//첫 줄에 피보나치 수열을 출력합니다.

package Ch2_Array.$4.피보나치수열;

import java.util.ArrayList;
import java.util.Scanner;

// 9분 30초 소요. 이전값과 현재값을 계속 변수에 저장해서 구하니까 쉽게 되었다.
public class Main {
    public ArrayList<Integer> solution(int n){
        int pre = 1;
        int next = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(1);
        // 피보나치 수열 출력 (항은 10개로 해보기)
        for(int i=2; i<n; i++){
            int tmp = pre+next;
            answer.add(tmp);
            pre=next;
            next=tmp;

        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int x : T.solution(n)){
            System.out.print(x+" ");

        }
    }
}

//문제풀이
// int 배열에 값을 담고, 배열에 있는 값으로 다음 값을 구했다.(나처럼 변수지정을 안하니까 깔끔하네)
class Solution {
    public int[] solution(int n){
        // 피보나치 수열 출력 (항은 10개로 해보기)
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++){
            answer[i] = answer[i-2]+answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int x : T.solution(n)){
            System.out.print(x+" ");

        }
    }
}