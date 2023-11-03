//설명
//현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
//현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
//송아지는 움직이지 않고 제자리에 있다.
//현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
//최소(DFS) 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

//입력
//첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

//출력
//점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

package Ch7_Recursive_Tree_Graph.$8.송아지찾기BFS상태트리탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] jump = {-1, 1, 5};
    static int[] check = new int[10001];

    public int BFS(int s, int e){

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        check[s] = 1;
        int L = 0;
        while (!Q.isEmpty()){
            int nowSize = Q.size();
            for(int i=0; i<nowSize; i++){
                int tmp = Q.poll();
                for(int j=0; j<jump.length; j++){

                    if(tmp+jump[j] == e){
                        return L+1;
                    }
                    if(tmp+jump[j]>= 1 && tmp+jump[j]<=10000 &&check[tmp+jump[j]] == 0){
                        Q.offer(tmp+jump[j]);
                        check[tmp+jump[j]] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        int s = S.nextInt();
        int e = S.nextInt();

        System.out.println(T.BFS(s,e));
    }

}