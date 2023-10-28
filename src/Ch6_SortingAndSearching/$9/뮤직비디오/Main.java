package Ch6_SortingAndSearching.$9.뮤직비디오;
/*설명
지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.

입력
첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.

출력
첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.*/

import java.util.*;
import java.util.Scanner;

// 결정알고리즘이란?
// 이분검색(바이너리서치)를 이용하여 lt, rt사이에 답이있다고 판단될 경우만 사용한다.
// lt = 9, rt = 45 (DVD 하나의 용량은 최소 9는 되어야하고 최대는 45가 되어야한다)
// 중간값이 답으로써 가능한지 확인한다, 계속 줄여가면서 최소로써 답이 가능한 값을 찾는다

public class Main {
    // 검증할 메서드
    public int check(int[] arr, int capacity){
        // cnt 는 현재 dvd
        int cnt = 1;
        // sum은 dvd에 들어갈 길이
        int sum = 0;
        // arr을 포문으로 돌면서
        for(int x: arr){
            // 현재 sum값에 x를 더했을때 중간값보다 커지면
            if(sum+x > capacity){
                // 다음 dvd에 담기 위해 cnt를 증가시키고
                cnt++;
                // 다음 dvd는 현재 x값부터 담겨야 하기 때문에 sum을 x로 초기화시킨다
                sum = x;
            // 현재 sum 값이 아직 mid 보다 작으면, dvd용량에 여유가 있다는 뜻이므로 sum에 계속 더한다
            } else {
                sum += x;
            }
        }

        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0;

        // 배열에서 최대값, 합계값을 얻는방법
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt<=rt){
            int mid = (lt+rt)/2;
            // count반환값은 현재 mid기준(dvd 용량)으로 dvd가 몇개만들어질수 있는지 갯수를 반환함
            if(m >= check(arr,mid)){
                answer = mid;
                rt= mid-1;
            } else {
                lt = mid+1;
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