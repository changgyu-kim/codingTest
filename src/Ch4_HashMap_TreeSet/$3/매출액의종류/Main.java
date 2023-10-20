//설명
//현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
//각 구간별로 구하라고 했습니다.
//만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
//20 12 20 10 23 17 10
//각 연속 4일간의 구간의 매출종류는
//첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
//두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
//세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
//네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
//N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
//매출액의 종류를 출력하는 프로그램을 작성하세요.

//입력
//첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
//두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

//출력
//첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.

package Ch4_HashMap_TreeSet.$3.매출액의종류;

import java.util.*;

//30분 시간초과.. 범위 내 슬라이딩 윈도우를 만들고 if조건들로 맵에 담아 중복된값을 빼고 출력하고있는데 시간이 너무 많이 소요 되었다..
// 접근법은 맞았는데 초반에 괜히 value값은 필요없다고 생각되어 hashset으로 접근하다 시간날리고 hashmap으로 바꾼게 컷다.
// 빨리하려고 주석을 안달고 하는 습관이생겨 짠 코드가 햇갈려서 더 오히려 시간을 잡아먹게 되었다. 앞으로 무조건 주석을 달자.
public class Main {
    public ArrayList solution(int n, int m, int[] arr){
        ArrayList answer = new ArrayList();

        // 슬라이딩 윈도우를 담을 맵 객체
        Map<Integer, Integer> map = new HashMap<>();

        // map 객체에 m크기의 arr 키값 담기
        for( int i=0; i<m; i++){
            // map 객체에 감고 value 값이 없으면 0으로 하고 +1 하기
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        // answer 에 첫번째 슬라이딩 윈도우 갯수 넣기
        answer.add(map.size());

        int lt = 0;
        // 슬라이딩 윈도우 n크기까지 증가시키기
        for(int rt=m; rt<n; rt++ ){
            // 새로운 값 map에 저장
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            // 기존 lt위치의 키값을 하나 뺀다
            map.put(arr[lt], map.get(arr[lt])-1);
            // 뺀 키의 값이 0이면
            if(map.get(arr[lt]) == 0){
                // 그 키값 제거
                map.remove(arr[lt]);
            }
            lt++;
            answer.add(map.size());
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        for(Object x: T.solution(n,m,arr)){
            System.out.print(x+" ");
        }
    }
}

