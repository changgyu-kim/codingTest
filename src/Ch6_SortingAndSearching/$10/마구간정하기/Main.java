package Ch6_SortingAndSearching.$10.마구간정하기;

import java.util.Arrays;
import java.util.Scanner;
/*설명
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

출력
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.*/
public class Main {
    public int check(int[] arr, int mid){
        // 말의 수를 카운트할 cnt 값
        int cnt = 1;
        // 거리의 좌표를 저장할 값
        // 인덱스 0 에 한마리를 먼저 배치해놓기 위해
        int ep = arr[0];

        for(int i=1; i<arr.length; i++){
            // 만약 포문 돌면서 arr[i] 에서 ep를 뺀 값이 mid 보다 크거나 같다면 ep에 i 위치를 넣고
            // cnt 를 증가시켜서 다음말을 놓을곳을 확인한다.
            if(arr[i]-ep >= mid){
                ep= arr[i];
                cnt++;
            }
        }
        return cnt;

    }

    public int solution(int n, int m, int[] arr){
        int answer = 0;

        // 배열을 오름차순 정렬하고
        Arrays.sort(arr);

        // 두 말의 최대 거리를 구해야 하기때문에 거리의 범위를 결정해준다
        int lt = 1;
        int rt = arr[n-1];

        // while 문을 돌면서 최대거리를 mid로 정하고
        while(lt<=rt){
            int mid = (lt+rt)/2;
            // m(말의 마리수)가 mid를 거리로했을때 m보다 크거나 같다는건 그많큼 거리에 여유가 아직 있다는 뜻
            // count메서드의 반환값(mid 거리로 배치했을때 몇마리 배치할 수 있는지 반환해줌) 보다 작거나 같으면
            // mid 거리까지는 가능하다는 의미이므로 answer에 mid값을 담고 mid값 보다 더 좋은 값을 찾아야하므로
            // lt값에 mid+1 을 해서 최대값을 찾아나선다
            if(m <= check(arr,mid)){
                answer = mid;
                lt = mid+1;
            // count메서드의 반환값보다 m이 크면 거리가 멀어 3마리 배치가 어렵다는 뜻이므로
            // rt 범위를 mid 범위보다 좁혀 가능 한 값을 찾는다.
            } else {
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
