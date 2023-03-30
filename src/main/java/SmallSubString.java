package main.java;

import java.util.*;

public class SmallSubString {
	
	
	/* 2023-03-30
	 * 프로그래머스
	 * java 크기가 작은 부분 문자열
	 * Level 1 
	 * lessons ( 147355 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution("3141592", "271"));
	}
	
	//숫자로 이루어진 문자열 t와 p가 주어짐
	//t에서 p와 길이가 같은 부분 문자열 중에서 이 부분 문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 획수를 return
	//예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592
	//이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개
	public static int solution(String t, String p) {
        int answer = 0;
        
        //p의 길이
        int pLength = p.length();
        System.out.println(pLength);
        
        //t의 길이
        int tLength = t.length();
        System.out.println(tLength);

        //길이만큼 루프
        int loop = (tLength - pLength)+1;
        for(int i=0; i< loop; i++)    {
        	//길이 만큼 t를 잘라서 확인
            String result = t.substring(i, pLength);
            pLength++;
            
            //나온 결과가 p보다 작은지 확인 있으면 answer++
            if(Long.parseLong(result) <= Long.parseLong(p)){
                System.out.println(result);
                answer++;
            }
        }
        return answer;
    }
}