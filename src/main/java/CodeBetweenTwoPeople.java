package main.java;

import java.util.*;

class CodeBetweenTwoPeople {
	
	
	/* 2023-03-27
	 * 프로그래머스
	 * java 둘만의 암호
	 * Level 1
	 * lessons ( 155652 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution("aukks", "wbqd", 5));
	}

	//두 문자열 s 와 skip, 자연수 index 가 두어질때의 암호해독
	//1. 문자열 s의 각 알파뱃을 index 만큼 뒤의 알파벳으로 바꿈
	//2. index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아감
	//3. skip 에 있는 알파벳은 제외하고 건너뜀
	public static String solution(String s, String skip, int index) {
        String answer = "";
        
        //a = '97'; , z='122';
        char ch='a';
        
        ArrayList<Integer> skipList = new ArrayList<>();
        
        for(int i=0; i<skip.length(); i++){
            char one = skip.charAt(i);
            int two = (int)one;
            skipList.add(two);
        }
        System.out.println(skipList);
        
        for(int i =0; i< s.length(); i++){
            char cc = s.charAt(i);
            int tt = (int)cc;
            int count = 0;
            while(true){
               if(count == index){
                    answer += (char)tt;
                    break;
                }

                tt++;
                if(tt >122){
                    tt= 97;
                }

                if(skipList.contains(tt)){

                }else {
                    count++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}