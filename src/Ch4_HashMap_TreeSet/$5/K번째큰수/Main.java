//설명
//현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
//현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
//기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
//만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.

//입력
//첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.

//출력
//첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.

package Ch4_HashMap_TreeSet.$5.K번째큰수;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

//  30분 초과.. 역순정렬해서 하면되는데 중복카드가 있을수도 있다고해서 어렵네.. 링크드해쉬맵 써야하는건가??
// 중복제거와 정렬에 대한 문제는 트리셋을 활용해야 했다. 난 입력된 값을 내림차순했는데 k값이 50까지 입력될 수 있으므로
// 3중 포문으로 모든 경우의 수의 값을 구하고 그걸 트리셋에 담아 정렬을 해야했다.
public class Main {
    public int solution(int n, int m, Integer[] arr){
        int answer = 0;

        // 트리셋 생성 내림차순 정렬 설정
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // 모든 경우의 수는 트리셋에 저장
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    set.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        // m번째 위치의 큰값을 찾기위한 카운트 변수
        int cnt = 1;
        for(int x : set){
            if(cnt == m){
                return x;
            }
            cnt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Integer[] arr = new Integer[n];
        for(Integer i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}
// TreeSet 자주사용되는 메서드
// 1. size() 키가 몇개있는지 갯수를 나타냄
// 2. first() 오름차순에서는 최소값, 내림차순에서는 최대값을 받음
// 3. last() 오름차순에서는 최대값, 내림차순에서는 최소값을 받음