package Ch6_SortingAndSearching.$2.버블정렬;

import java.util.Scanner;

// 3분소요. 버블정렬 원리만 알면 쉽다. 까먹지 않게 기억하자
public class Main {
    public int[] solution(int n, int[] arr){
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }

        for(int x : T.solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}
