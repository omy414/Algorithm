package main.java;

import java.util.*;

public class NearSameWord {
	
	/* 2023-03-31
	 * 프로그래머스
	 * java 가장 가까운 같은 글자
	 * Level 1
	 * lessons ( 142086 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution("banana"));
		System.out.println(solution("apple"));
	}
	
	//문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지
	//예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
	//b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	//a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	//n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	//a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
	//n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
	//a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
	//따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
	public static int[] solution(String s) {
        int[] answer = new int[s.length()];
       HashMap<Character, Integer> map1 = new HashMap<>();
       HashMap<Character, Integer> map2 = new HashMap<>();


       for (int i = 0; i<s.length(); i++) {
           if (!map1.containsKey(s.charAt(i))) {
           	System.out.println("여기 탄 글자 : " + s.charAt(i));
               map1.put(s.charAt(i), i);
               map2.put(s.charAt(i), -1);

               answer[i] = -1;
           }
           else {
                   map2.put(s.charAt(i), i - map1.get(s.charAt(i)));
                   System.out.println(i + " " + map1.get(s.charAt(i)));
                   map1.put(s.charAt(i), i);
               answer[i] = map2.get(s.charAt(i));
           }
           System.out.println(answer[i]);
       }
       return answer;
   }
}