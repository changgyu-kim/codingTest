//문제
//자연수 N이 입력된면 N!를 구하는 프로그램을 작성하세요.
//예를 들어 5! = 5*4*3*2*1=120입니다.

package Ch7_Recursive_Tree_Graph.$3.팩토리얼;

import java.util.Scanner;

public class Main {
    public int DFS(int n){
        if(n==1) return 1;
        else {
            return n*DFS(n-1);

        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        T.DFS(n);
    }
}
