//설명
//N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
//
//입력
//첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
//두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
//
//출력
//N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력

package Ch1_String.$4.단어뒤집기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public String[] solution(int n, String[] arrArr){
        String[] answer = new String[n];

        for(int i=0; i<arrArr.length; i++){
            StringBuilder build = new StringBuilder(arrArr[i]);
            answer[i] = build.reverse().toString();
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] strArr = new String[n];
        for(int i=0; i<n; i++){
            strArr[i] = s.next();
        }
        for(String x : T.solution(n, strArr)){
            System.out.println(x);
        }
    }
}

// 문제풀이
// 1. StringBuilder 의 reverse 메서드 활용
class Solution {
    // solution 메서드
    public ArrayList<String> solution(int n, String[] str){
        // 결과값을 담을 ArrayList 생성
        ArrayList<String> answer = new ArrayList<>();
        
        // 받아온 str 배열을 하나씩 가져옴
        for(String x : str){
            // 가져온 str 값을 스트링 빌더 객체 생성 시 변수로 활용하고 reverse 메서드를 사용하여 값 뒤집고 String 타입으로 반환
            String tmp = new StringBuilder(x).reverse().toString();
            // tmp의 값을 answer에 추가
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 솔루션 클래스 객체 생성
        Solution T = new Solution();
        // 스캐너 객체 생성
        Scanner s = new Scanner(System.in);
        // n에 입력받을 문자열에 대한 값 받기
        int n = s.nextInt();
        // n의 값만큼의 길이를 가진 String 배열 생성
        String[] str = new String[n];
        // n의 크기만큼 입력받을 문자열을 String배열로 받기 받기
        for(int i=0; i<n; i++){
            str[i] = s.next();
        }
        // 솔루션 클래스의 solution 메서드에서 값을 String으로 하나씩 가져옴
        for(String x: T.solution(n, str)){
            System.out.println(x);
        }

    }
}

// 2. 직접 뒤집는 방법
class Solution2 {
    // solution 메서드
    public ArrayList<String> solution(int n, String[] str){
        // 결과값을 담을 ArrayList 생성
        ArrayList<String> answer = new ArrayList<>();

        // 받아온 str 배열을 하나씩 가져옴
        for(String x : str){
            // str 값을 char 배열로 바꿈
            char[] c = x.toCharArray();
            // c 의 시작과 끝 index의 값을 만듬
            int front = 0;
            int end = c.length-1;
            // front 가 end 랑 같아지기 전까지 반복함
            while (front < end){
                // c 배열의 값을 서로 바꿔줌
                char tmp = c[front];
                c[front] = c[end];
                c[end] = tmp;
                front++;
                end--;
            }
            // 바꾼 char 객체를 String 객체로 형변환
            String tmp = String.valueOf(c);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 솔루션 클래스 객체 생성
        Solution2 T = new Solution2();
        // 스캐너 객체 생성
        Scanner s = new Scanner(System.in);
        // n에 입력받을 문자열에 대한 값 받기
        int n = s.nextInt();
        // n의 값만큼의 길이를 가진 String 배열 생성
        String[] str = new String[n];
        // n의 크기만큼 입력받을 문자열을 String배열로 받기 받기
        for(int i=0; i<n; i++){
            str[i] = s.next();
        }
        // 솔루션 클래스의 solution 메서드에서 값을 String으로 하나씩 가져옴
        for(String x: T.solution(n, str)){
            System.out.println(x);
        }

    }
}