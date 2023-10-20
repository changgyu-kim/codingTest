//설명
//0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
//만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
//1 1 0 0 1 1 0 1 1 0 1 1 0 1
//이며 그 길이는 8입니다.

//입력
//첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
//두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

//출력
//첫 줄에 최대 길이를 출력하세요.

package Ch3_TwoPointers_SlidingWindow.$6.최대길이연속부분수열;

import java.util.Scanner;

// 30분 초과 로직은 짰는데 1개만 정답이고 나머지 값이 다 오답이네... 뭐가문제인지를 모르겠다.
// 아 다시보니  1 1 0 1 이면 length를 4로 해야하는데 3으로 했엇네.. ㅋㅋㅋ
public class Main {
    public int solution(int n, int m, int[] arr){
        int answer = 0;
        int lt = 0;
        int length = 0;
        int zero = 0;
        for(int rt = 0; rt<n; rt++){
            length += arr[rt];
            if(arr[rt] == 0){
                zero++;
                if(zero > m){
                    answer = Math.max(length+m, answer);
                    zero--;
                    while (0 != arr[lt]){
                        length -= arr[lt];
                        lt++;
                    }
                    lt++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}

//문제풀이 접근방법은 나와 같았다