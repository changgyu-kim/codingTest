//문제
//자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
//N(1<=N<=10)

package Ch7_Recursive_Tree_Graph.$6.부분집합구하기DFS;


public class Main {
    static int n;
    static int[] ch;
    public void DFS(int L){

        // 현재 L값이 n+1 값이면(== 하나의 경우의 수가 결정 되었을 때)
        if(L == n+1){
            // tmp에 현재 ch배열에 1인 값들을 담는다
            String tmp = "";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1){
                    tmp += i+" ";
                }
            }
            // tmp가 공집합이 아닐때 출력한다
            if(tmp.length()>0) System.out.println(tmp);
        // 현재 L값이 n+1이 아니면
        } else {
            ch[L] = 1;   // 1로 값을 주어 O 라는 표시 해주기
            DFS(L+1); // 왼쪽으로 뻗기
            ch[L] = 0;   // 0으로 값을 주어 X 라는 표시 해주기
            DFS(L+1); // 오른쪽으로 뻗기
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);

    }


}

