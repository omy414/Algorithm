package main.java;

import java.util.*;

public class NumericNEnglish {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}
	
	public static int solution(String s) {
        int answer = 0;
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for (int i = 0; i < word.length; i++) {
			s = s.replace(word[i], String.valueOf(i));
		}
        
        System.out.println(s);
        answer = Integer.parseInt(s);
        return answer;
    }
}