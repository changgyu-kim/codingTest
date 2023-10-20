//설명
//A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
//두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
//네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//각 집합의 원소는 1,000,000,000이하의 자연수입니다.
//
//출력
//두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


package Ch3_TwoPointers_SlidingWindow.$2.공통원소구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//10분소요.
public class Main {
    public ArrayList<Integer> solution(int n, int m , int[] arrA, int[] arrB){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] arr = new int[n+m];
        int tmp = 0;
        for(int i=0; i<n; i++){
            arr[i] = arrA[i];
        }
        for(int i=0; i<m; i++){
            arr[n+i] = arrB[i];
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(tmp == 0){
                tmp = arr[i];
            } else {
                if(tmp == arr[i]){
                    answer.add(arr[i]);
                    tmp = 0;
                } else {
                    tmp = arr[i];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
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

// 문제풀이
// 이 문제는 교집합 구하는 문제이다
// 교집합문제도 각 배열을 오름차순을 해준뒤 두개의 포인터를 이용해서 값을 구할 수 있다.
class Solution {
    public ArrayList<Integer> solution(int n, int m , int[] arrA, int[] arrB){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        // 포인터 두개 만들기
        int p1 = 0;
        int p2 = 0;

        // 오름차순 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        while (p1<n && p2<m){
            if(arrA[p1] < arrB[p2] ){
                p1++;
            } else if(arrA[p1] == arrB[p2]){
                answer.add(arrA[p1++]);
                p2++;
            } else {
                p2++;
            }
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