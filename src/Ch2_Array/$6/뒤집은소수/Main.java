//설명
//N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
//예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
//첫 자리부터의 연속된 0은 무시한다.
//
//입력
//첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
//각 자연수의 크기는 100,000를 넘지 않는다.
//
//출력
//첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.

package Ch2_Array.$6.뒤집은소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();

        int [] reverseArr = new int[n];

        for(int i=0; i<n; i++){
            String tmp = String.valueOf(arr[i]);
            StringBuilder stringBuilder = new StringBuilder(tmp);
            reverseArr[i] = Integer.parseInt(stringBuilder.reverse().toString());
        }

        for(int x : reverseArr){
            if(x >= 2){
                int ch = 0;
                for(int i=2; i<x; i++){
                    // x 보다 낮은 값으로 나누어 지면 소수가 아님
                    if(x % i == 0){
                        ch = 1;
                        break;
                    }
                }
                if(ch == 0){
                    answer.add(x);
                }

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

        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}


// 문제풀이
// " / " 와 " % " 를 활용하여 숫자를 뒤집고, 소수는 자기자신만 나눌수 있다는 점을 이용하여 소수임을 증명했다.

class Solution {
    public boolean isPrime(int reverse){
        if(reverse == 1){
            return false;
        }
        for(int i=2; i<reverse; i++){
            if(reverse % i == 0){
                return false;
            }
        }

        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();



        for(int i=0; i<arr.length; i++){
            int tmp = arr[i];
            int reverse = 0;
            while(tmp>0){
                int t = tmp%10;
                reverse = reverse*10+t;
                tmp = tmp/10;
            }
            if(isPrime(reverse)){
                answer.add(reverse);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        for(int x: T.solution(n ,arr)){
            System.out.print(x+" ");
        }
    }
}
