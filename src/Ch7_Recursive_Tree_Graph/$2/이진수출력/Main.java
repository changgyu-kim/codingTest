//문제
//10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야 합니다.

//10진수를 2진수로 바꾸는 방법은 10진수를 2로 계속 몫이 0이 될 때까지 나눈 나머지이다

package Ch7_Recursive_Tree_Graph.$2.이진수출력;

import java.util.Scanner;

public class Main {
    public void DFS(int n){
        if(n == 1){
            System.out.println(n);
        } else {
            DFS(n/2);
            System.out.println(n%2);
        }


    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        T.DFS(n);
    }
}
