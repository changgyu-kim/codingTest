package Ch8_DFS_BFS.$5.동전교환;
/*설명
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.*/
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public void solution(int L, int sum) {
        if(L > answer) return;
        if(sum > m) return;
        if(sum == m){
            if( L < answer){
                answer = L;
            }
        } else {
            for(int i=0; i<n; i++){
                solution(L+1, sum+arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new Integer[n];
        for(int i=0; i<n; i++){  // 작은수 부터 경우의수를 따지면 너무 오래걸리기 때문에 내림차순으로 바꿔줘야 함
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder()); // Collections를 사용하려면 참조형이여야 한다
        m = s.nextInt();
        T.solution(0,0);
        System.out.println(answer);
    }
}
