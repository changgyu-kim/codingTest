package Ch3_TwoPointers_SlidingWindow.$3.최대매출;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr){
        int answer = 0;

        int max = 0;
        int lt = 0;
        int rt = m;
        for(int i=lt; i<rt; i++){
            max += arr[i];
        }
        answer = max;

        while (rt < n){
            max -= arr[lt++];
            max += arr[rt++];
            answer = Integer.max(answer,max);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(T.solution(n,m,arr));

    }
}

// 문제풀이
//// 슬라이딩 윈도우(범위를 정해두고 밀고가는 것)를 활용해야한다.
class Solution {
    public int solution(int n, int m , int[] arrA){
        int answer = 0;
        int sum = 0;
        // 입력된 m번째 전 까지의 합을 더해서 윈도우(범위)를 만듬
        for(int i=0; i<m; i++){
            sum += arrA[i];
        }

        answer = sum;

        // 입력된 m번째부터 n까지 for문 진행
        for(int i=m; i<n; i++){
            // 기존 sum값에 맨앞값을 빼고 뒤에 값을 추가시키면서 for문 진행
            sum += arrA[i]-arrA[i-m];
            answer = Math.max(answer,sum);
        }


        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arrA = new int[n];
        for(int i=0; i<arrA.length; i++){
            arrA[i] = s.nextInt();
        }
        System.out.print(T.solution(n,m,arrA));
    }
}
