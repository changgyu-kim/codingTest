package Ch6_SortingAndSearching.$4.LeastRecentlyUsed;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

// 30분 초과.. 접근은 잘한것 같은데 왜 자꾸 에러가 나지..?
// forEach와 map.get으로 값을 바꾸니까 정상적으로 됐다. 원래는 for문으로 i값을 증가시키면서하니까 에러난듯
// 40이 걸렸지만 풀긴풀었다
public class Main {
    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];

        TreeMap<Integer, Integer> map = new TreeMap(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            if(!map.containsValue(arr[i])){
                map.put(i, arr[i]);
            } else {
                for(int x : map.keySet()){
                    if(map.get(x) == arr[i]){
                        map.remove(x);
                        break;
                    }
                }
                map.put(i, arr[i]);
            }
        }

        int cnt = 0;

        for(int x : map.keySet()){
            if(cnt<s){
                answer[cnt] =  map.get(x);
                cnt++;
            } else {
                break;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int x : T.solution(s,n,arr)){
            System.out.print(x+" ");
        }
    }
}

// 문제풀이
// 삽입정렬을 이용하여 풀었다.
class Solution {
    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];

        for(int x : arr){
            int pos = -1;

            for(int i=0; i<answer.length; i++){
                if(arr[i] == x){
                    pos = i;
                }
            }
            if(pos == -1){
                for(int i=answer.length-1; i>=1; i--){
                    answer[i] = answer[i-1];
                }

            // pos != -1
            } else {
                for(int i=pos; i>=1; i--){
                    answer[i] = answer[i-1];
                }
            }
            answer[0] = x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int x : T.solution(s,n,arr)){
            System.out.print(x+" ");
        }
    }
}
