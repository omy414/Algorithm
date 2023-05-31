package main.java;

import java.util.*;

public class AddYinYang {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,7,12}, new boolean[] {true,false,true}));
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
			boolean temp = signs[i];
			answer = temp ? answer + absolutes[i] : answer - absolutes[i];
		}
        
        return answer;
    }
}