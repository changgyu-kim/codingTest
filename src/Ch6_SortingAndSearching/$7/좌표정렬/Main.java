package Ch6_SortingAndSearching.$7.좌표정렬;

import java.util.*;
/*설명
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.*/

class Point implements Comparable<Point>{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x-o.x == 0){
            return this.y-o.y;
        } else {
            return this.x - o.x;
        }
    }

}

public class Main {
    public List<Point> solution(int n, List<Point> list){

        List<Integer> answer = new ArrayList<>();
        Collections.sort(list);

        return list;

    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int[][] arr = new int[n][2];
        List<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = S.nextInt();
            int y = S.nextInt();
            list.add(new Point(x,y));
        }
        for(Point p : T.solution(n,list)){
            System.out.print(p.x+" "+p.y);
            System.out.println();
        }
    }
}


