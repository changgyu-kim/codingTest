package Ch9_GreedyAlgorithm.$3.결혼식;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Time implements Comparable<Time>{ // tiem클래스에 도착, 떠나는 시간을 변수해 해봤다 답이없다.
                                        // 시간과 상태를 변수로 지정하여 어떤상태의 시간인지 나타내주어야한다
    public int time;
    public char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time m){
        if(this.time==m.time){ // 시간이 같다면 상태로 오름차순정렬
            return this.state-m.state;
        } else {
            return this.time-m.time;
        }
    }

}

public class Main {
    public int solution(int n, ArrayList<Time> list){
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(list);
        for(Time x : list){
            if(x.state =='s'){
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer,cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int start = s.nextInt();
            int end = s.nextInt();
            list.add(new Time(start,'s'));
            list.add(new Time(end,'e'));
        }
        System.out.println(T.solution(n,list));
    }
}
