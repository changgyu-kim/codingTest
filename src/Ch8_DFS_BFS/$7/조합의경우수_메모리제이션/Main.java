package Ch8_DFS_BFS.$7.조합의경우수_메모리제이션;

import java.util.Scanner;

public class Main { // 이차원의 메모리제이션을 사용한다., 조합수의 재귀를 끝내는 조건은 두 수가 같거나 r이 0이되는 경우이다
    static int n;
    static int r;
    static int[][] check;

    public int DFS(int n,int r){
        if(r == 0){
            return 1;
        } else if(n == r){
            return 1;
        } else {
            return check[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        n = S.nextInt();
        r = S.nextInt();
        check = new int[n+1][r+1];
        System.out.println(T.DFS(n, r));

    }
}
