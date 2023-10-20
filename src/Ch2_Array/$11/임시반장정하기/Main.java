//설명
//김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
//김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
//그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
//그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
//예를 들어 학생 수가 5명일 때의 표를 살펴보자.
//위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
//2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
//같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
//이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
//각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
//둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
//주어지는 정수는 모두 1 이상 9 이하의 정수이다.
//
//출력
//첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
//단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.

package Ch2_Array.$11.임시반장정하기;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public int solution(int n, int[][] arr){
        int answer = 0;

        int student = 0;
        int cnt =  0 ;
        int ban = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            student = i+1;
            for(int j=0; j<5; j++){
                ban = arr[i][j];
                for(int k=0; k<n; k++){
                    if(ban == arr[k][j]){
                        set.add(k+1);
                    }
                }
            }
            if(set.size() > cnt){
                cnt = set.size();
                answer = student;
            }
            set.clear();
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][5];
        for(int i=0; i<n; i++){
            for( int j=0; j<5; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}

// 문제풀이
// 3중 포문을 쓰는건 나와 같았지만, for문 i,j를 행과 열로 잡지 않고 문제에 맞도록 현재 학생과, 비교할 학생으로 잡고
// k를 1~5반까지의 값으로 진행시켰다
// 이렇게하니까 내가 해결못했던 중복된 학생에 대하여 j에서 tmp++ 가 발생했을때 break를 진행하면 해결할 수 있었다.
class Solution {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int tmp;
        int max = 0;
        for(int i=1; i<=n; i++){
            tmp=0;
            for(int j=0; j<=n; j++){
                for(int k=1; k<=5; k++){
                    if(arr[i][k] == arr[j][k]){
                        tmp++;
                        break;
                    }
                }
            }
            if(tmp > max){
                max = tmp;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n+1][6];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}