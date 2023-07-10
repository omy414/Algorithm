package main.java;

import java.util.*;

public class DartGame {
	public static void main(String[] args) {
		System.out.println(solution("1D2S#10S"));
	}
	
	public static int solution(String dartResult) {
        int answer = 0;
        
        String aa = "1A";
        
        //System.out.println(Integer.parseInt(aa));
        //System.out.println(aa.matches("[0-9]"));
        
        int score = 0;
        
        int sum = 0;
        
        int[] list = new int[3];
        
        for (int i = 0; i < dartResult.length(); i++) {
			char temp = dartResult.charAt(i);
			System.out.println(String.valueOf(temp));
			
			System.out.println(String.valueOf(temp).matches("[0-9]"));
			
			if(String.valueOf(temp).matches("[0-9]")) {
				if(i != 0) {
					list[sum] = score;
					sum++;
					//sum+=score;
				}
				score = Integer.parseInt(String.valueOf(temp));
			}
			
			if(String.valueOf(temp).matches("[A-Z]")) {
				if("S".equals(String.valueOf(temp))) {
					
				}else if("D".equals(String.valueOf(temp))) {
					score = score * score;
				}else if("T".equals(String.valueOf(temp))) {
					score = score * score * score;
				}
			}
			
			if("*".equals(String.valueOf(temp))) {
				score = score * 2;
				
				System.out.println("sum : " + sum);
				System.out.println("무슨값? : " + list[sum]);
				if(sum != 0) {
					if(list[sum-1] != 0) {
						list[sum-1] = list[sum-1]*2;
					}
				}
				
			}else if("#".equals(String.valueOf(temp))){
				score = score * (-1);
			}
			
			if(i == (dartResult.length() -1)) {
				list[sum] = score;
				//sum+=score;
			}
		}
        System.out.println(list[0]);
        System.out.println(list[1]);
        System.out.println(list[2]);
        
        sum = 0;
        for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
        System.out.println("합계 : " + sum);
        
        
        return answer;
    }
}