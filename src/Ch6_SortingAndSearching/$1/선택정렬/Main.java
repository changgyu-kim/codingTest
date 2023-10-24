package Ch6_SortingAndSearching.$1.선택정렬;

import java.util.Scanner;

// 8분소요. 선택정렬을 알고 접근하니까 쉽다
public class Main {
    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];

        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        for(int i=0; i<n; i++){
            answer[i] = arr[i];
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

        for(int x : T.solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}
