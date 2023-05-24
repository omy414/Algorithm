package main.java;


import java.util.*;

public class AddNumber {
	
	/* 2023-05-24
	 * 프로그래머스
	 * java 없는 숫자 더하기
	 * Level 1
	 * lessons ( 86051 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {5,8,4,0,6,7,9}));
	}
	
//	0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
	public static int solution(int[] numbers) {
        int answer = 45;
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
			number += numbers[i];
		}
        answer = answer - number;
        
        return answer;
    }
}