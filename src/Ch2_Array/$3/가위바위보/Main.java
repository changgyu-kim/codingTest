//설명
//A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
//가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
//두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
//
//입력
//첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
//두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
//세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
//
//출력
//각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.


package Ch2_Array.$3.가위바위보;

import java.util.ArrayList;
import java.util.Scanner;
// 1(가위), 2(바위), 3(보)/ 1은 3이김(-2), 2는 1(1)이김, 3은 2(1) 이김
// 20분 소요, 이기는 경우 지는경우 비기는 경우로 나누어서 구했다.
public class Main {
    public ArrayList<String> solution(int n, int[] arrA, int[] arrB){
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            if((arrA[i]-arrB[i]) == 1 || (arrA[i]-arrB[i]) == -2 ){
                answer.add("A");
            } else if((arrB[i]-arrA[i]) == 1 || (arrB[i]-arrA[i]) == -2 ) {
                answer.add("B");
            } else {
                answer.add("D");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for(int i=0; i<arrA.length; i++){
            arrA[i] = s.nextInt();
        }
        for(int i=0; i<arrB.length; i++){
            arrB[i] = s.nextInt();
        }
        for(String x : T.solution(n,arrA,arrB)){
            System.out.println(x);
        }
    }
}

// 문제풀이
// 나와 같은 방식으로 풀었다.
// String 같은 경우에는 char로 String 값을 하나씩 빼와서 해도된다 ArrayList사용하지 않고