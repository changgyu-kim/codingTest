// 문제
// 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요,


package Ch8_DFS_BFS.$9.조합구하기;

import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] combi;

    public void DFS(int L, int s){
        if(L == m){
            for(int x : combi){
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i = s; i<=n; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s= new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        combi = new int[m];

        T.DFS(0, 1);
    }
}
