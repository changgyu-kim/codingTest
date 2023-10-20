//설명
//자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
//만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
//
//입력
//첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
//
//출력
//첫 줄에 소수의 개수를 출력합니다.

package Ch2_Array.$5.소수;

import java.util.Scanner;

public class Main {
    public int solution(int n){
        int answer = 0;

        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++){
            if(arr[i] == 0){
                answer++;
                for(int j=i; j<=n; j=j+i){
                    arr[j] = 1;
                }
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

//문제풀이
// 소수를 구하는 문제는 에라토스테네스 체(소수를 판별하는알고리즘)로 접근해야한다.
// 에라토스테네시 체 구현방법
// 1. 배열을 생성하여 초기화한다(0으로 초기화).
// 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 1로바꾼다.(바꿀때 자기자신의 값이 0이면 갯수카운트 후 1로 바꾸고 자기의 배수 값도 다 1로 바꾼다.)
class Solution {
    public int solution(int n){
        int answer = 0;

        // 입력된 값 n의 길이 보다 1개 더해야 길이가 0~20까지 생긴다. (2~20까지 사용할 예정)
        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++){
            // 만약 arr[i]의 값이 0이면 (== 아직 이전수의 배수가 아닐경우)
            if(arr[i] == 0){
                // 소수이므로 카운트한다.
                answer++;
                // 현재 값의 배수를 찾아서 배수일 경우 값을 1로 바꾼다.
                for(int j=i; j<=n; j=j+i){
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(T.solution(n));
    }
}