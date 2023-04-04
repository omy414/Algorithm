package main.java;

import java.util.*;

public class FruitSeller {
	
	public static void main(String[] args) {
		System.out.println(solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
	}
	
	public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int boxSize = score.length/m;
        int min = 10;
        int sum =0;
        
        int temp = score.length -1;
        int count =0;
        for (int i = temp; i >= 0; i--) {
        	count++;
        
    		min = Math.min(min, score[i]);
    		
    		if(count == m) {
        		sum += min *m;
        		temp -=m;
        		count =0;
        	}
			
		}
        answer = sum;
        return answer;
    }
}