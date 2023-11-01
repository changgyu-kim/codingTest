//문제
//피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다
//입련은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 4 8 13을 출력하면 된다.

package Ch7_Recursive_Tree_Graph.$4.피보나치재귀.메모리제이션;

import java.util.Scanner;

public class Main {
    // 이렇게 재귀의 값을 기록해 두는 것을 메모리제이션이라고하고
    static int[] fibo;
    public int DFS(int n){
        // 이걸 활용하여 이런식으로 빠르게 값을 계산하게끔 할 수 있다.
        if(fibo[n] > 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] =  DFS(n-1)+DFS(n-2);

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fibo = new int[n+1];

        T.DFS(n);
        for(int i=1; i<fibo.length; i++){
            System.out.print(fibo[i]+" ");

        }
    }
}
