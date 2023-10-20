//설명
//학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
//투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
//선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
//반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
//
//입력
//첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
//두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
//
//출력
//학급 회장으로 선택된 기호를 출력합니다.

package Ch4_HashMap_TreeSet.$1.학급회장;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public Character solution(int n, String str){
        char answer = ' ';
        int max = 0;

        Map<Character,Integer> map = new HashMap();

        for(char x : str.toCharArray()){
            map.put(x,(map.getOrDefault(x,1))+1);
        }
        for(char x : map.keySet()){
            if(map.get(x) > max){
                max = map.get(x);
                answer = x;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        System.out.println(T.solution(n,str));

    }
}

// HashMap 의 getOrDefault( , ) 메서드는 값이 없을때는 명시한 디폴트값을 가져오는 메서드이다
// HashMap 의 size() 메서드는 키의 갯수가 몇개인지 알려주는 메서드이다.
// HashMap 의 remove(키명) 메서드는 특정키를 삭제하는 메서드이다.
