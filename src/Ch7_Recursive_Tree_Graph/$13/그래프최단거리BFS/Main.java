// 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력할 때 사용

package Ch7_Recursive_Tree_Graph.$13.그래프최단거리BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] ch;
    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph;
    public void BFS(int v){
        ch[v] = 1;
        dis[v] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while(!Q.isEmpty()){
            int cv = Q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s= new Scanner(System.in);
        n= s.nextInt();
        m= s.nextInt();
        ch = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
