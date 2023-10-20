//설명
//현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
//멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
//선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
//만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
//M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
//두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
//만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
//
//출력
//첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

package Ch2_Array.$12.멘토링;

import java.util.Scanner;

// 포기.. 접근방법을 모르겠다
public class Main {
    public int solution(int row,int col ,int[][] arr){
        int answer = 0;
        int tmp = 0;
        for(int k=1; k<col; k++){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(arr[i][j] != k){
                        if(arr[i][j] > k){
                            
                        }
                    }
                    System.out.print(arr[i][j]+" ");

                }
                System.out.println();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int col = s.nextInt();
        int row = s.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(row,col,arr));
    }
}

// 문제풀이
// 내가 접근하고 있는 방법은 맞았는데 끝까지 도전하질 못했다.
// 4중 for문을 통해 두개의 값을 비교하는 방식으로 진행했다.
class Solution {
    public int solution(int row,int col ,int[][] arr){
        int answer = 0;

        // 첫번째 학생의 번호
        for(int fs=1; fs<=col; fs++){
            // 두번째 학생의 번호
            for(int es=1; es<=col; es++){
                int cnt = 0;
                // 첫번째학생과 두번째 학생을 비교
                for(int i=0; i<row; i++){
                    int pfs = 0;
                    int pes = 0;
                    for(int j=0; j<col; j++){
                        // 만약 현재 i번째 테스트에서 첫번째 학생이 발견된다면
                        if(arr[i][j] == fs){
                            // pfs에 현재 배열순위 넣기
                            pfs = j;
                        }
                        // 만약 현재 i번째 테스트에서 두번째 학생이 발견된다면
                        if(arr[i][j] == es){
                            // pes에 현재 배열순위 넣기
                            pes = j;
                        }
                    }
                    // pfs > pes 면 cnt 올리기
                    if(pfs > pes){
                        cnt++;
                    }
                }
                // 만약 cnt == 테스트 길이와 같다면( 첫번째 학생이 두번째 학생보다 다 앞선순위라면 )
                if(cnt == row){
                    // asnwer 에 1추가
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int col = s.nextInt();
        int row = s.nextInt();
        int[][] arr = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(row,col,arr));
    }
}