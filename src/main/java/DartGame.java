package main.java;

import java.util.*;

public class DartGame {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
	}
	
	public static int solution(String dartResult) {
		String[] temp = dartResult.split("^[a-zA-Z]*$");
		System.out.println(temp[0]);
        int answer = 0;
        StringTokenizer st = new StringTokenizer(dartResult, "[a-zA-Z]*$");
        System.out.println(st.nextToken());
        
        return answer;
    }
}