//설명
//5*5 격자판에 아래와 같이 숫자가 적혀있습니다.
//N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
//
//입력
//첫 줄에 자연수 N이 주어진다.(2<=N<=50)
//두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
//
//출력
//최대합을 출력합니다.

package Ch2_Array.$9.격자판최대합;

import java.util.Scanner;

// 15분 소요. 이중포문을 이용해서 대각, 가로,세로를 각각 변수에 값을 대입하여 현재 max보다 큰경우만 계속 덮어서 값을 구했다
public class Main {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int row = 0;
        int col = 0;
        int cross = 0;
        int reveseCross = 0;

        for(int i=0; i<arr.length; i++){
            cross += arr[i][i];
            reveseCross += arr[arr.length-1-i][arr.length-1-i];

            for(int j=0; j<arr[i].length; j++){
                row += arr[i][j];
                col += arr[j][i];
            }
            if(row>answer){
                answer = row;
            }
            if(col>answer){
                answer = col;
                System.out.println("answer = " + answer);
            }
            if(cross>answer){
                answer = cross;
            }
            if(reveseCross>answer){
                answer = reveseCross;
            }
            row = 0;
            col = 0;
        }
        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}

// 문제풀이
// 나와 비슷하지만 max 값을 구할 때 Math.max 을 사용하여 값을 산출했다.