// 문제
// 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
// 중복순열이란 중복을 포함하여 조건에 따라 순서대로 나열하는 것이다, 중복이 가능할 경우에는 이진트리가 아니라 N트리로 경우의수가 뻗어나간다
package Ch8_DFS_BFS.$4.중복순열구하기;

import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static int[] pm;

    public void solution(int L) {
        if(L == m){
            for(int x : pm){
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++){
                pm[L] = i;
                solution(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        pm = new int[m];
        T.solution(0);

    }
}
