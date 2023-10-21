//설명
//S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

//입력
//첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
//S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

//출력
//S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

package Ch4_HashMap_TreeSet.$4.모든아나그램찾기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public int solution(String strS, String strT){
        int answer = 0;

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i=0; i<strT.length(); i++){
            mapS.put(strS.charAt(i),mapS.getOrDefault(strS.charAt(i),0)+1);
            mapT.put(strT.charAt(i),mapT.getOrDefault(strT.charAt(i),0)+1);
        }
        if(mapS.equals(mapT)){
            answer++;
        }
        int lt = 0;
        int rt = strT.length()-1;
        while (rt < strS.length()-1){
            rt++;
            mapS.put(strS.charAt(rt),mapS.getOrDefault(strS.charAt(rt),0)+1);
            mapS.put(strS.charAt(lt),(mapS.get(strS.charAt(lt)))-1);
            if(mapS.get(strS.charAt(lt)) == 0){
                mapS.remove(strS.charAt(lt));
            }
            lt++;
            if(mapS.equals(mapT)){
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String strS = s.next();
        String strT = s.next();
        System.out.println(T.solution(strS,strT));
    }
}
