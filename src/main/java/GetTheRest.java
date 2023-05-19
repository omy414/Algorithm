package main.java;

import java.util.*;

public class GetTheRest {
	public static void main(String[] args) {
		System.out.println(solution(3));
	}
	
	public static int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= 1000000; i++) {
        	if(n % i == 1) {
        		System.out.println("N : " + n);
        		System.out.println("I : " + i);
        		int num = 1;
        		while((i/num) >0) {
        			System.out.println("여기들어옴?" + num);
        			if(i/num != 0) {
        				answer = num;
        				num++;
        			}
        		}
        		break;
        	}
		}
        
        return answer;
    }
}