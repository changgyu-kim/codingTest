//문제
//자연수 N이 입력된면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
//첫 번째 줄은 정수 N(3<=N<=10)이 입력된다

package Ch7_Recursive_Tree_Graph.$1.재귀함수;

import java.util.Scanner;

public class Main {
    public void DFS(int n){
        // n이 3일때
        if(n==0){
            return;
        } else {
            DFS(n-1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        T.DFS(n);
    }
}