//문제
//방향그래프가 주어지만 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
//아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지수는
//1 2 3 4 5
//1 2 5
//1 3 4 2 5
//1 3 4 5
//1 4 2 5
//1 4 5
//총 6가지 입니다.

package Ch7_Recursive_Tree_Graph.$11.경로탐색DFS인접행렬;

import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v == m){
            answer++;
        } else {
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0; // 가다가 뒤로갔을때는 했던행동을 취소해주어야 한다
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = 1;
        }
        ch[1]=1;
        T.DFS(1);



    }

}
