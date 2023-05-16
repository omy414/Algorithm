package main.java;

import java.util.*;


public class Babbling {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"wooayaye", "uuu", "yeye", "yemawoo", "ayamaaya"}));
	}
	
	public static int solution(String[] babbling) {
		int answer = 0;
        for (String s : babbling) {
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            s = s.replaceAll("aya|ye|woo|ma", "");
            if (s.equals(""))
                answer++;
        }
        return answer;
    }
}