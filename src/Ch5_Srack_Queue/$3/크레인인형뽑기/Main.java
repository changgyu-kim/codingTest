package Ch5_Srack_Queue.$3.크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(int n, int[][] board, int m, int[] moves){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int x : moves){
            for(int i=1; i<n+1; i++){
                if(board[i][x] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[i][x] ){
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][x]);
                    }
                    board[i][x] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] board = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                board[i][j] = s.nextInt();
            }
        }
        int m = s.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = s.nextInt();
        }
        System.out.println(T.solution(n,board,m,moves));
    }
}
