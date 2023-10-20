//설명
//지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
//각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
//격자의 가장자리는 0으로 초기화 되었다고 가정한다.
//만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

//입력
//첫 줄에 자연수 N이 주어진다.(2<=N<=50)
//두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

//출력
//봉우리의 개수를 출력하세요.

package Ch2_Array.$10.봉우리;

import java.util.Scanner;

// 11분 소요. 이중포문을 이용해서 현재 arr의 값의 상하좌우를 if문으로 체크해서 가장크면 answer의 값을 증가시켰다
public class Main {
    public int solution(int n, int[][] arr){
        int answer = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                // 만약 현재 arr이 상하좌우보다 크기가 크다면 answer++ 하기
                if((arr[i][j] > arr[i-1][j]) && (arr[i][j] > arr[i+1][j]) && (arr[i][j] > arr[i][j-1]) && (arr[i][j] > arr[i][j+1])){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n+2][n+2];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}

// 문제풀이
// if문으로 상하좌우를 체크할경우 상하좌우 말고 범위가 더 늘어나면 if문이 길어져서 관리하기 힘들기 때문에
// int[] 배열로 x, y축의 확인해야할 위치를 저장해놓고 3중for문을 돌면서 체크하는방법을 사용하였다.
class Solution {
    public int solution(int n, int[][] arr){
        int answer = 0;
        // 현재 arr위치에 대한 12시, 3시, 6시, 9시 방향 위치
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                // 시계방향으로 돌면서 아닐 시 바로 k for문을 빠져나오기 위한 용도
                boolean check = true;
                for(int k=0; k<4; k++){
                    // 상우하좌 가 클경우
                    if(arr[i+dx[k]][j+dy[k]]>arr[i][j]){
                        check = false;
                        break;
                    }
                }
            if(check){
                answer++;
            }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n+2][n+2];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}