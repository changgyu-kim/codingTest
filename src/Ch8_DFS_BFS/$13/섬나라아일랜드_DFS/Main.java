package Ch8_DFS_BFS.$13.섬나라아일랜드_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
만약 위와 같다면 섬의 개수는 5개입니다.

입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.

출력
첫 번째 줄에 섬의 개수를 출력한다.*/
class Point{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Main {
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int answer = 0;

    public void DFS(Point p) {
        for (int k = 0; k < 8; k++) {
            int nx = p.x + dx[k];
            int ny = p.y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(new Point(nx, ny));
            }
        }
    }

    public int solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    answer++;
                    DFS(new Point(i,j));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        n = S.nextInt();
        board = new int [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = S.nextInt();
            }
        }
        System.out.println(T.solution());
    }
}
