//설명
//한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
//문장속의 각 단어는 공백으로 구분됩니다.
//
//입력
//첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
//
//출력
//첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.

package Ch1_String.$3문장속단어;

import java.util.Scanner;

public class Main {
    public String solution(String arr){
        String answer = "";
        int length = 0;

        String[] str = arr.split(" ");

        for(String x : str){
            if(x.length() > length){
                length = x.length();
                answer = x;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String arr = s.nextLine();

        System.out.println(T.solution(arr));
    }
}

// 문제풀이
// 해결방법1. 나와 비슷하게 string의 split 메서드를 활용하는 방법

// 해결방법2. indexof (= 처음발견되는 값의 index를 리턴해준다) 와 substring을 활용하는 방법

// 해결방법