package Ch9_GreedyAlgorithm.$1.씨름선수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Person implements Comparable<Person>{
    public int h;
    public int w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        return o.h - this.h ;
    }
}

public class Main {

    public int solution(int n, List<Person> list){
        int answer = 0;
        Collections.sort(list);
        int max = 0;
        for(Person x : list){
            if(x.w > max){
                max = x.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = S.nextInt();
            int b = S.nextInt();
            list.add(new Person(a, b));
        }
        System.out.println(T.solution(n, list));
    }
}
