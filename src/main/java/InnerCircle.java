package main.java;

import java.util.*;

public class InnerCircle {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {-1,0,1}, new int[] {1,0,-1}));
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < b.length; i++) {
			answer += a[i]*b[i];
		}
        return answer;
    }
}