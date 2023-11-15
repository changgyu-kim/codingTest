package Ch9_GreedyAlgorithm.$4.최대수입스케줄_PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture l){
        return l.date-this.date;
    }
}

public class Main {
    static int longDate = 0;

    public int solution(int n,ArrayList<Lecture> list){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=longDate; i>=1; i--){
            for(int j=0; j<n; j++){
                // longDate 값보다 작으면 내림차순 되어있는 값이기 때문에 의미 없어서 break;
                if(list.get(j).date == i){
                    pQ.offer(list.get(j).money);
                }
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Lecture> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int money = s.nextInt();
            int date = s.nextInt();
            if(date > longDate) longDate = date;
            list.add(new Lecture(money, date));
        }
        System.out.println(T.solution(n,list));
    }
}
