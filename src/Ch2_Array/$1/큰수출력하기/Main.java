//설명
//N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
//(첫 번째 수는 무조건 출력한다)
//
//입력
//첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
//
//출력
//자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

package Ch2_Array.$1.큰수출력하기;

import java.util.ArrayList;
import java.util.Scanner;

// 24분 소요, 값이 12 이렇게 주어졌을경우 문자열로 접근했다가 오래걸렸다.
// 문자열로 접근하니까 1,2로 읽어가지고 문제가 되네.. 다시 문자열 배열로 접근해서 해결했다
public class Main {
    public String solution(int n, int[] arr){
        String answer = "";

        for(int i=0; i<n; i++){
            if(i==0){
                answer += arr[i]+" ";
            } else if(arr[i] > arr[i-1]){
                answer += arr[i]+" ";
            } else {

            }
        }


        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }

        System.out.println(T.solution(n,arr));

    }
}

//// 문제풀이
class Solution {
    public ArrayList<Integer> solution(int num, int[] arr){
        // 리스트형식으로 반환하기
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=0; i<num; i++){
            if(arr[i]-arr[i-1]>0){
                answer.add(arr[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        // 입력된 num을 활용하여 int 배열을 만든다
        int[] arr = new int[num];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        for(int x : T.solution(num,arr)){
            System.out.println(x+" ");
        }

    }
}
