package main.java;

import java.util.*;


public class Threesome {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {-2, 3, 0, 2, -5}));
	}
	
	public static int solution(int[] number) {
        int answer = 0;
        
        for (int i = 0; i <= number.length-3; i++) {
        	int check1 = 0;
        	check1 = number[i];
        	for (int j = i+1; j < number.length-1; j++) {
        		check1 += number[j];
        		for (int j2 = j+1; j2 < number.length; j2++) {
        			check1 += number[j2];
        			if(check1 == 0) {
                        answer++;
        			}
        			check1 -= number[j2];
				}
        		check1 -= number[j];
    		}
		}
        return answer;
    }
}