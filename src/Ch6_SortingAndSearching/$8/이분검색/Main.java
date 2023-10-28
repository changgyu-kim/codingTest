package Ch6_SortingAndSearching.$8.이분검색;

import java.util.Arrays;
import java.util.Scanner;
/*설명
임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.

입력
첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.

출력
첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.*/
// 문제라기보다 바이너리서치를 잘 숙지하도록 하는 문제이다

// cnt 를 arr.length 로 주는게 아니라 범위를 알아야하니까 lt,rt로 나누어서 줘야 로직이 가능했다..
public class Main {
    public int solution(int n, int m, int[] arr){
        int answer = 0;

        Arrays.sort(arr);

        // 배열의 위치를 나타냄
        int lt = 0;
        int rt = arr.length-1;

        while(true){
            // mid 값을 while문 안에 써서 계속 바뀐 값을 초기화 시켜줘야 한다
             int mid = (lt+rt)/2;
             if (m == arr[mid]) {
                answer = mid+1;
                break;
            }
            // arr의 절반에 있는 값보다 크다면 arr길이를 arr.length/2 보다 위로 정해야함
            // mid 값에 +1, -1 을 하는 이유는 mid 값에 앞 뒤의 값을 lt rt 에 적용시켜야 하기 때문에 그럼
            if(m > arr[mid]){
                lt = mid+1;
                // arr의 절반에 있는 값보다 작다면
            }else {
                rt = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(n,m,arr));

    }
}
