// 문제
// 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

// 설명
// 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다
// 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.

// 첫 번째 줄에 결과를 출력합니다.
// 출력순서는 사전순으로 오름차순으로 출력합니다.

// 입력
// 3 2
// 3 6 9

// 출력
// 3 6
// 3 9
// 6 3
// 6 9
// 9 3
// 9 6

package Ch8_DFS_BFS.$6.순열구하기;

import java.util.Scanner;

public class Main { // 중복수열이 아니고 그냥 수열문제임
    // 체크배열을 사용하는 이유는 중복을 제거하기 위해서이다.
    static int n;
    static int m;
    static int[] ch;
    static int[] pm;
    static int[] arr;

    public void DFS(int L){
        if(L == m){
            for(int x : pm){
                    System.out.print(x+" ");
                }
            System.out.println();
        } else {
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;

                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s= new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        pm = new int[m];
        ch = new int[n];
        T.DFS(0);



    }


}
