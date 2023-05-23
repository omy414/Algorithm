package main.java;


import java.util.*;

public class Rectangle {
	/* 2023-05-23
	 * 프로그래머스
	 * java 최소직사각형
	 * Level 1 
	 * lessons ( 86491 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60,50},{30,70},{60,30},{80,40}}));
	}
	
	public static int solution(int[][] sizes) {
        int answer = 0;
        
        int maxW = 0; 
        int maxH = 0;
        
        for (int i = 0; i < sizes.length; i++) {
			int size[] = sizes[i];
			
			int w = size[0];
			int h = size[1];
			
			if(h > w) {
				if(h > maxW) {
					maxW = h;
				}
				if(w > maxH) {
					maxH = w;
				}
			}else {
				if(h > maxH) {
					maxH = h;
				}
				if(w > maxW) {
					maxW = w;
				}
			}
		}
        System.out.println("맥스? : " +  maxW + " / " + maxH);
        answer = (maxW*maxH);
        return answer;
    }
}