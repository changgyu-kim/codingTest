//설명
//N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
//만약 N=15이면
//7+8=15
//4+5+6=15
//1+2+3+4+5=15
//와 같이 총 3가지의 경우가 존재한다.

//입력
//첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

//출력
//첫 줄에 총 경우수를 출력합니다.

package Ch3_TwoPointers_SlidingWindow.$5.연속된자연수의합;

import java.util.Scanner;

public class Main {
    public int solution(int n){
        int answer = 0;

        int lt = 1;
        int rt = 2;
        int sum = lt+rt;

        while(lt+rt <= n){
            if(sum > n){
                sum -= lt;
                lt++;
            } else if (sum == n) {
                answer++;
                sum -= lt;
                lt++;
                rt++;
                sum += rt;
            } else {
                rt++;
                sum += rt;
            }
        }



        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(T.solution(n));

    }
}

// 문제풀이
// 나와 같다