package main.java;

import java.util.*;

public class CokeProblem {
	/* 2023-05-29
	 * 프로그래머스
	 * java 콜라문제
	 * Level 1
	 * lessons ( 155652 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(2, 1, 20));
	}
	
	public static int solution(int a, int b, int n) {
        int answer = 0;
        int rest = 0;
        
        while(n >= a) {
        	if(n>a && n%a != 0) {
            	rest += n%a; 
            	
            }
            answer += (n/a)*b;
            n = (n/a)*b;
            
            if(rest != 0) {
            	if((n/a) < 1) {
                	while(n != a) {
                		if(rest == 0) {
                			break;
                		}
                		rest--;
                		n++;
                	}
                }
            }
        }
        
        return answer;
    }
	
	//아래는 다른사람이 푼 아름다운 답...;
	public int solution2(int a, int b, int n) {
        return (n > b ? n - b : 0) / (a - b) * b;
    }
}