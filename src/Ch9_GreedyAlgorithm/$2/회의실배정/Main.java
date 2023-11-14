package Ch9_GreedyAlgorithm.$2.회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 회의가 빨리끝나는 순으로 오름차순을 해야한다.(== 끝나는 시간을 기준으로 해야함) 빨리끝나야 회의를 많이 할 수 있으니까, 이후에 시작시간에 대한 오름차순도 필요함
class Meet implements Comparable<Meet>{
    public int s;
    public int e;

    public Meet(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meet m) {
        if(this.e == m.e){
            return this.s - m.s;
        } else {
            return this.e - m.e ;

        }
    }
}

public class Main {

    public int solution(int n, List<Meet> list){
        int answer = 0;
        Collections.sort(list);
        int start = 0;
        for(Meet x : list){
            if(x.s >= start){
                start = x.e;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        List<Meet> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = S.nextInt();
            int e = S.nextInt();
            list.add(new Meet(s,e));
        }
        System.out.println(T.solution(n, list));
    }
}
