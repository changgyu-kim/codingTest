//설명
//오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
//두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
//세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
//네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
//각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
//
//출력
//오름차순으로 정렬된 배열을 출력합니다.

package Ch3_TwoPointers_SlidingWindow.$1.두배열합치기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<Integer> solution(int n, int m, int[] nArr, int[] mArr){
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        int p1 = 0;
        int p2 = 0;

        while (p1<n && p2 < m){
            if(nArr[p1] > mArr[p2]){
                p2++;
            } else if(nArr[p1] == mArr[p2]){
                answer.add(nArr[p1]);
                p1++;
                p2++;

            } else {
                p1++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] nArr = new int[n];
        for(int i=0; i<n; i++){
            nArr[i] = s.nextInt();
        }

        int m = s.nextInt();
        int[] mArr = new int[m];
        for(int i=0; i<m; i++){
            mArr[i] = s.nextInt();
        }

        for(int x : T.solution(n,m,nArr,mArr)){
            System.out.print(x+" ");
        }

    }
}

// 문제풀이
// 위처럼 풀어도 되지만 포문을 두번돌고 소트함수도 포문을 돌면서 효율이 너무 않좋다.
// 두 배열간에는 두개의 pointer를 이용해서 해결하자!
class Solution {
    public ArrayList<Integer> solution(int n, int m , int[] arrA, int[] arrB){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        // 포인터 두개 만들기
        int p1 = 0;
        int p2 = 0;

        while (p1<n && p2<m){
            if(p1 < p2 ){
                answer.add(arrA[p1++]);
            } else {
                answer.add(arrB[p2++]);
            }
        }
        while (p1<n){
            answer.add(arrA[p1++]);
        }
        while (p2<m){
            answer.add(arrB[p2++]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arrA = new int[n];
        for(int i=0; i<arrA.length; i++){
            arrA[i] = s.nextInt();
        }
        int m = s.nextInt();
        int[] arrB = new int[m];
        for(int i=0; i<arrB.length; i++){
            arrB[i] = s.nextInt();
        }
        for(int x : T.solution(n,m,arrA, arrB)) {
            System.out.print(x+" ");
        }
    }
}