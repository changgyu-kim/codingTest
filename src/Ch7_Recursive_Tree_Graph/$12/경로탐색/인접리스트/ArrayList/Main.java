// 정점이 1000~~ 1000000 개 일때는 인접행렬로 접근하기에는 비효율적이기때문에
// 인접리스트로 접근해야 한다.

// 1번정점으로 N번 점정으로 가는 모든 경로의 가지 수를 출력하는 경우

package Ch7_Recursive_Tree_Graph.$12.경로탐색.인접리스트.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v == n){
            answer++;
        } else {
            for(int x : graph.get(v)){
                if(ch[x] == 0){
                    ch[x] = 1;
                    DFS(x);
                    ch[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
